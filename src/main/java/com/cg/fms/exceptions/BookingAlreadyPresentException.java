package com.cg.fms.exceptions;

public class BookingAlreadyPresentException extends RuntimeException{
	public BookingAlreadyPresentException(String message) {
		super(message);
	}
}
