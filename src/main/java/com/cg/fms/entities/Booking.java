package com.cg.fms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Min(value=1,message="Id Should not be null")
	@Column(name="bookingid")
	private long bookingId;
	
//	@ManyToOne
//   @JoinColumn(name = "userid")
//	private User UserId;

	@NotNull
	@Column(name="date")
	private LocalDate bookingDate;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengerList = new ArrayList<Passenger>();		
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="flightid")
//	private Flight flight;
	

	private int noOfPassengers;


public Booking(long bookingId, int noOfPassengers) {
	super();
	this.bookingId = bookingId;
	this.noOfPassengers = noOfPassengers;
}
	

//  @ManyToOne
//  Users users;
	
//	public void addPassengers(Passenger passengers)
//	{
//		passengers.setBooking(this);
//		this.getPassengerList().add(passengers);
//
//	}
	

	
}

