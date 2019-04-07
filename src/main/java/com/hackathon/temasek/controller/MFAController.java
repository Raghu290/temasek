package com.hackathon.temasek.controller;

import java.util.Optional;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableAutoConfiguration
public class MFAController {

	@RequestMapping(value = "/mfaAuthentication", method = RequestMethod.GET)
	public String getLoginDetails() {
	
		return "ready for sms";
	}
}
