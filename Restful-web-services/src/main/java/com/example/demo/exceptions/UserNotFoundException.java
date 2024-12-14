package com.example.demo.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(Integer id) {
		super("User is not found with id: "+id);
	}

}
