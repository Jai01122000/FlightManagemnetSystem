package com.cg.fms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Flight {

	@Id
	//Sequence generated from 10004 auto increment by 1
	@GeneratedValue
	@Column(name="fno")
	long flightNumber;
	
	@Column(name="cname")
	String carrierName;
	
	@Column(name="fmodel")
	String flightModel;
	
	@Column(name="seatcap")
	int seatCapacity;
	
	//Default unparameterized constructor
	}