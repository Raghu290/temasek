package com.hackathon.temasek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.temasek.exception.UserIdAlreadyPresentException;
import com.hackathon.temasek.model.Email;
import com.hackathon.temasek.model.ResponseBody;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.service.RegistrationService;
import com.hackathon.temasek.utility.ApplicationConstants;



@RestController
@SessionAttributes("contextPath")
@PropertySource("classpath:configuration.properties")
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private Environment environment;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(Model model) {
		return new ModelAndView("register", "command", new User());
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseBody addCustomer(@RequestBody User user) {
	System.out.println("registering user");
	ResponseBody responseBody = new ResponseBody();
		try{
			registrationService.registerUser(user);
			Email email = new Email();
			email.setEmailMessage(environment.getProperty("RegistrationController.SUCCESSFUL_REGISTRATION"));
			System.out.println("registering user success :" +environment.getProperty("RegistrationController.SUCCESSFUL_REGISTRATION"));
			email.setSubject("Registration confirmation");
			email.setToEmail(user.getEmail());
			jmsTemplate.convertAndSend("mailbox", email);
		
		
			
		}catch(UserIdAlreadyPresentException e){
			responseBody.setStatusMessage(e.getMessage());
			if (e.getMessage().contains("RegistrationService")) {	
				responseBody.setStatusMessage( environment.getProperty(e.getMessage()));
			}
			responseBody.setStatusCode(ApplicationConstants.FAILURE);
			
		}
		responseBody.setStatusCode(ApplicationConstants.SUCCESS);
		responseBody.setStatusMessage(environment.getProperty("RegistrationController.SUCCESSFUL_REGISTRATION"));
		return responseBody;
	}
	
	
	
	@Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
