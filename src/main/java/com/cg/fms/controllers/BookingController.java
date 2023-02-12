	package com.cg.fms.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Booking;
import com.cg.fms.services.BookingService;


@RestController
public class BookingController {
	
    @Autowired
	BookingService bs;

	@PostMapping("/bookings")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking newBooking)
	{
		Booking bkng= bs.createNewBooking(newBooking);
		ResponseEntity<Booking> rEntity = new ResponseEntity<Booking>(bkng,HttpStatus.CREATED);
		return rEntity;
	}
	
	@PutMapping("/bookings/{bookingId}")
	public ResponseEntity<Booking> modifyBooking(@PathVariable("bookingId") long bookingId, @RequestBody Booking newBooking)
	{
		
		Booking bkng = bs.updateBooking(bookingId, newBooking);
		ResponseEntity<Booking> rEntity=new ResponseEntity<Booking>(bkng,HttpStatus.FOUND);
		return rEntity;
	}
	
	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable ("bookingId") long bookingId)
	{
		Booking bkng = bs.viewBooking(bookingId);
		ResponseEntity<Booking> rEntity = new ResponseEntity<Booking>(bkng,HttpStatus.FOUND);
		return rEntity;
	}
	
	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> viewBookings()
	{
		List<Booking> bkng = bs.viewAllBooking();
		ResponseEntity<List<Booking>> rEntity = new ResponseEntity<List<Booking>>(bkng,HttpStatus.FOUND);
		return rEntity;
	}
	
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable ("bookingId") long bookingId)
	{
		String bkng =bs.deleteBooking(bookingId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(bkng,HttpStatus.FOUND);
		return rEntity;

	}
	
	
	
}
