package com.hackathon.temasek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.UserEntity;
import com.hackathon.temasek.exception.UserIdAlreadyPresentException;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.repository.UserRepository;


@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	

	
	public void registerUser(User user) throws UserIdAlreadyPresentException{
		UserEntity ue = userRepository.findOne(user.getUserId());
		if(ue!=null)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
		UserEntity userEntity = new UserEntity();
		userEntity.setCity(user.getCity());
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhone());
		userEntity.setUserId(user.getUserId());
		userRepository.saveAndFlush(userEntity);		
	}
	
	
}
