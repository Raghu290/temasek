package com.hackathon.temasek.exception;

@SuppressWarnings("serial")
public class UserIdAlreadyPresentException extends Exception {
	public UserIdAlreadyPresentException(String message){
		super(message);
	}

}
