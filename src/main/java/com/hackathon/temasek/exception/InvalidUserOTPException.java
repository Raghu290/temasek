package com.hackathon.temasek.exception;

public class InvalidUserOTPException extends Exception {
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
	public InvalidUserOTPException(String message) {
		super(message);
	}
}
