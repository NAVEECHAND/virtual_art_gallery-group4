package com.exception;

public class InvalidUserCredentials extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public InvalidUserCredentials(String string) {
		this.message=string;
	}

	public String getMessage() {
		return message;
	}
	
	
}
