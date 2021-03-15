package com.tweetapp.tweetapplication.execption;

public class IncorrectLoginCredentialsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IncorrectLoginCredentialsException(String message) {
		super(message);
	}

}
