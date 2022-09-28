package com.dropdownajex.exception;

import org.springframework.http.HttpStatus;

public class MyException extends RuntimeException {
	
	
	String resourceName;
	String fieldName;
	HttpStatus badRequest;
	
	

	public MyException(String resourceName, String fieldName, HttpStatus badRequest) {
		super(String.format("%s not found with % : %l", resourceName, fieldName, badRequest));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.badRequest = badRequest;
	}

}
