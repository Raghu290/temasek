/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.temasek.controller;

import java.security.Principal;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.temasek.entity.UserEntity;
import com.hackathon.temasek.exception.InvalidCredentialException;
import com.hackathon.temasek.exception.InvalidUserOTPException;
import com.hackathon.temasek.model.Login;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.service.LoginService;
import com.hackathon.temasek.service.SMSService;




@RestController
public class LoginController {


	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SMSService smsService;
	
	@Autowired
	private Environment environment;




	@RequestMapping(value = "/login", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authenticateLogin(Principal user) {		

		//ModelAndView modelAndView = new ModelAndView("error");
		System.out.println("customer name "+ user.getName());
		smsService.sendSMS(user.getName());	
	   
		
		return "BAsic Authentication success for user :"+user.getName() +".Please enter OTP sent to mobile";

	}

	@RequestMapping(value = "/validateOTP", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validateOTP(@RequestBody Login login,HttpSession session,Principal user) {		
    try {
		loginService.validateOTP(login);
     }catch (InvalidUserOTPException e) {
    		System.out.println("validateOTP "+ user.getName());
    	 invalidateSession(session);
    		System.out.println("validateOTP after sesison invalidation "+ user.getName());
	     return environment.getProperty(e.getMessage());
	     

	} catch (InvalidCredentialException e) {
		
	    return environment.getProperty(e.getMessage());
	}
    return "OTP authenticated";
	}
	
	private void invalidateSession(HttpSession session) {
		Enumeration<String> attributes = session.getAttributeNames();

		while (attributes.hasMoreElements()) {
			System.out.println("session invalidation :");
			session.removeAttribute(attributes.nextElement());
		}
		
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		
		ModelAndView model = new ModelAndView("infyGoHome", "", "");

		Enumeration<String> attributes = session.getAttributeNames();

		while (attributes.hasMoreElements())
			session.removeAttribute(attributes.nextElement());
		
		model.addObject("logoutMessage", environment.getProperty("LoginController.LOGOUT_SUCCESS"));
		return model;
	}

	@RequestMapping(value = "/getmessage", method = RequestMethod.GET, produces = "application/json")
	public String getMessage() {
		
		return  "You have accessed a Basic Auth protected resource.";
	}
}
