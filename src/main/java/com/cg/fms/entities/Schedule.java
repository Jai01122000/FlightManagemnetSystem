package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Schedule {
	
	@Id
	@GeneratedValue
	long sid;
	
	String sourceAirport;	
	
	String destinationAirport;		

	@Column(name="atime")
	String arrivalTime;

	@Column(name="dtime")
	String departureTime;


	
}