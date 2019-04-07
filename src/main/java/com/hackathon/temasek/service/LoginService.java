/**
 * 
 */
package com.hackathon.temasek.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.UserEntity;
import com.hackathon.temasek.exception.InvalidCredentialException;
import com.hackathon.temasek.exception.InvalidUserOTPException;
import com.hackathon.temasek.model.Login;
import com.hackathon.temasek.repository.UserRepository;




/**
 * The Class AadharService.
 */
@Service

public class LoginService {

	@Autowired
	private UserRepository userRepository;	
	//@Autowired
	//private CounterService counterService;
	
	
	public UserEntity authenticateLogin(Login userLogin) throws InvalidCredentialException{
		
		
		UserEntity user = userRepository.findByUserId(userLogin.getUserName());
		
		
		
		
		if (user == null){	
		//	counterService.increment("counter.login.failure");
			
			throw new InvalidCredentialException(
					"LoginService.INVALID_CREDENTIALS");
		}
		else if(!(user.getPassword().equals(userLogin.getPassword()))){
			//counterService.increment("counter.login.failure");
			throw new InvalidCredentialException(
					"LoginService.INVALID_CREDENTIALS");
		}
		//counterService.increment("counter.login.success");
	
			return user;				
		

	}
	
	public UserEntity validateOTP(Login userLogin) throws InvalidCredentialException,InvalidUserOTPException{
		
		
		UserEntity user = userRepository.findByUserId(userLogin.getUserName());
     	if (user == null){	

			throw new InvalidCredentialException(
					"LoginService.INVALID_CREDENTIALS");
		}
		else if(!(user.getOtp().equals(userLogin.getOtp()))){
			//counterService.increment("counter.login.failure");
			throw new InvalidUserOTPException(
					"LoginService.INVALID_OTP");
		}
		userRepository.deleteOTP(userLogin.getUserName());
	
			return user;				
		

	}
	
	
}
