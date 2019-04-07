package com.hackathon.temasek.exception;

/**
 * 
 * This Exception is thrown from if the <br>
 * <b>loginName</b> is not in proper format or not matching any existing record,
 * or <br>
 * <b>password</b> entered is not in proper format or is incorrect against the
 * login name.
 * 
 * @author ETA_JAVA
 *
 */
public class InvalidCredentialException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from if the <br>
	 * <b>loginName</b> is not in proper format or not matching any existing record,
	 * or <br>
	 * <b>password</b> entered is not in proper format or is incorrect against the
	 * login name.
	 * 
	 * @author ETA_JAVA
	 *
	 */
	public InvalidCredentialException(String message) {
		super(message);
	}
}
