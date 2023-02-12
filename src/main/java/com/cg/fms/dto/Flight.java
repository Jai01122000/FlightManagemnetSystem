package com.cg.fms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {
	
	long flightNumber;
	
	String carrierName;
	
	String flightModel;
	
	int seatCapacity;
	
	//Default unparameterized constructor}
}