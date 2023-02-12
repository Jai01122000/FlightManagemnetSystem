package com.cg.fms.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class ScheduledFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
    private	Flight flight;

	@OneToOne
	private Schedule schedule;
	
	@Column(name="avalseat")
	private Integer availableSeats;

	public ScheduledFlight(long id, Integer availableSeats) {
		super();
		this.id = id;
		this.availableSeats = availableSeats;
	}
	

	
	
}
