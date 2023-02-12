package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="pnr")
	private long pnrNumber;
	
	@Column(name="name")
	private String passengerName;
	
	@Column(name="age")
	private int passengerAge;
	
	@Column(name="uin")
	private long passengerUIN;
	
	private Double luggage;
	
//	@ManyToOne
//	@JoinColumn
//	private Booking booking;
	
}

