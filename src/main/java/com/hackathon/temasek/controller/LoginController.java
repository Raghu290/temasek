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
import com.hackathon.temasek.model.ResponseBody;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.service.LoginService;
import com.hackathon.temasek.service.SMSService;
import com.hackathon.temasek.utility.ApplicationConstants;




@RestController
public class LoginController {


	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SMSService smsService;
	
	@Autowired
	private Environment environment;




	@RequestMapping(value = "/login", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBody authenticateLogin(Principal user) {		

		//ModelAndView modelAndView = new ModelAndView("error");
		System.out.println("customer name "+ user.getName());
		return smsService.sendSMS(user.getName());	
	   
		
		
	}

	@RequestMapping(value = "/validateOTP", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBody validateOTP(@RequestBody Login login,HttpSession session,Principal user) {	
		ResponseBody response = new ResponseBody();
    try {
		loginService.validateOTP(login);
     }catch (InvalidUserOTPException e) {
    		System.out.println("validateOTP "+ user.getName());
    	    invalidateSession(session);
    		System.out.println("validateOTP after sesison invalidation "+ user.getName());
    		response.setStatusCode(ApplicationConstants.FAILURE);
    		response.setStatusMessage(environment.getProperty(e.getMessage()));
	     return response;
	} catch (InvalidCredentialException e) {
		invalidateSession(session);
		response.setStatusCode(ApplicationConstants.FAILURE);
		response.setStatusMessage(environment.getProperty(e.getMessage()));
        return response;
	}
    response.setStatusCode(ApplicationConstants.SUCCESS);
	response.setStatusMessage("OTP Validation Success !!!");
    return response;
	}
	
	private void invalidateSession(HttpSession session) {
		Enumeration<String> attributes = session.getAttributeNames();

		while (attributes.hasMoreElements()) {
			System.out.println("session invalidation :");
			session.removeAttribute(attributes.nextElement());
		}
		
	}
	@RequestMapping(value = "/logout")
	public ResponseBody logout(HttpSession session) {
		ResponseBody response = new ResponseBody();
		Enumeration<String> attributes = session.getAttributeNames();
		while (attributes.hasMoreElements())
			session.removeAttribute(attributes.nextElement());	
		response.setStatusCode(ApplicationConstants.SUCCESS);
		response.setStatusMessage(environment.getProperty("LoginController.LOGOUT_SUCCESS"));
		return response ;
	}


}
