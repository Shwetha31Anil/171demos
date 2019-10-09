package com.mphasis.training.exceptions;

public class BuisnessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public BuisnessException(String message) {
		super(message);
	}
}
