package com.cg.fms.exceptions;

public class FlightCancelledException extends RuntimeException {
	public FlightCancelledException(String message) {
		super(message);
	}
}
