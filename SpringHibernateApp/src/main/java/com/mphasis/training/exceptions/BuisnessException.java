package com.mphasis.training.exceptions;

public class BuisnessException extends Exception {

	String message;
	public BuisnessException(String message) {
		super(message);
	}
}
