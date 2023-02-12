package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Airport_details")
public class Airport {
	@Id
	@Column(name = "Code")
	@NotEmpty(message = "AirportCode must be there!!")
	private String airportCode;
	@Column(name = "Name")
	@NotEmpty
	private String airportName;
	@Column(name = "Location")
	@NotEmpty
	private String airportLocation;
	
	@OneToOne
	private Schedule schedule;
}
