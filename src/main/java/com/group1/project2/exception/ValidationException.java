package com.group1.project2.exception;

public class ValidationException extends Exception{
	
	public String email;
	public String password;
	
	public ValidationException(String email,String password) {
		this.email = email;
		this.password =  password;
	}
	@Override
	public String getMessage() {
		return "Invalid email or password. Please try again.";
	}

}
