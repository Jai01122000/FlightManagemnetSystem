package com.cg.fms.exceptions;

public class FlightNumberNotFoundException extends RuntimeException {
	public FlightNumberNotFoundException (String message) {
		super(message);
	}
}
