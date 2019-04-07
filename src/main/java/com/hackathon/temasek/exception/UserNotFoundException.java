package com.hackathon.temasek.exception;

/**
 * 
 * This Exception is thrown from LoginService class with error
 * message <i>LoginService.CUSTOMER_NOT_FOUND</i> if the given 
 * <b>customerId</b> is not matching any existing record.
 * 
 * @author ETA_JAVA
 *
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * This Exception is thrown from LoginService class with error
	 * message <i>LoginService.CUSTOMER_NOT_FOUND</i> if the given 
	 * <b>customerId</b> is not matching any existing record.
	 * 
	 * @author ETA_JAVA
	 *
	 */
	public UserNotFoundException(String message)
	{
		super(message);
	}
}
