package com.hackathon.temasek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.UserEntity;
import com.hackathon.temasek.repository.UserRepository;
import com.hackathon.temasek.utility.SMSGenerator;

@Service
public class SMSService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Environment environment;
	
	public void sendSMS(String userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		System.out.println("SMSService :"+environment.getProperty("5160af9aa6b75f30df4581b2f5b1c75c"));
		SMSGenerator smsGenerator = new SMSGenerator(environment.getProperty("MOBTEXTING_ACCESS_TOKEN"));
		String otp = smsGenerator.send(userEntity.getPhone());
		
		userRepository.insertOTP(otp,userId);
	}
	
}
