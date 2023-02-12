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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.FlightNotFoundException;
import com.cg.fms.services.FlightService;

@RestController 
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	/*
	 URI : http://localhost:9001/flight/showAllFlights
	 METHOD : GET
	 */
	
	@PostMapping
	public ResponseEntity<Flight> addFlight (@RequestBody Flight flight){
		Flight fl = flightService.createNewFlight(flight);
		ResponseEntity<Flight> rEntity = new ResponseEntity<Flight> (fl, HttpStatus.CREATED);
		return rEntity;
	}
	
	@GetMapping
	public ResponseEntity<List<Flight>> showFlight()
	{
		List<Flight> fl = flightService.viewFlights();
		ResponseEntity<List<Flight>> rEntity = new ResponseEntity<List<Flight>>(fl, HttpStatus.FOUND);
		return rEntity;
	}
	
	@GetMapping("/{fno}")
	public ResponseEntity<Flight> viewFlight(@PathVariable("fno") long fno) throws FlightNotFoundException{
		Flight fl = flightService.viewFlight(fno);
		ResponseEntity<Flight> rEntity = new ResponseEntity<Flight>(fl, HttpStatus.FOUND);
		return rEntity;
		}
	
	@PutMapping("/{fno}")
	public ResponseEntity<Flight> updateFlight (@PathVariable("fno") long fno,@RequestBody Flight flight){
		Flight fl = flightService.updateFlight(flight);
		ResponseEntity<Flight> rEntity = new ResponseEntity<Flight>(fl, HttpStatus.FOUND);
		return rEntity;
	}
	
	@DeleteMapping("/{fno}")
	public ResponseEntity<String> deleteFlight(@PathVariable("fno") long fno){
		String fl = flightService.deleteFlight(fno);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(fl, HttpStatus.FOUND);
		return rEntity;
	}
	
}
