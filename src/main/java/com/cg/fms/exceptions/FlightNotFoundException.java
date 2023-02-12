package com.cg.fms.exceptions;

public class FlightNotFoundException extends RuntimeException{
	public FlightNotFoundException(String msg){
		super(msg);
	}

}
