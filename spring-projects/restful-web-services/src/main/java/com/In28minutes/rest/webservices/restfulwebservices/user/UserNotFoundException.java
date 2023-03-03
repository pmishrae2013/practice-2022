package com.In28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND) //returns response code manually(in this case 404)
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String exception) {
		super(exception); //makes a call to super class with this message which is Runtime Exception
	}
}
