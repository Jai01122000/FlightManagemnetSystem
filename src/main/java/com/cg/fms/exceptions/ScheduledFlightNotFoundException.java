package com.cg.fms.exceptions;

public class ScheduledFlightNotFoundException extends RuntimeException{
	public ScheduledFlightNotFoundException (String message) {
		super(message);
	}
}
