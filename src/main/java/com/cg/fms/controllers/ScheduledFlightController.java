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

import com.cg.fms.entities.ScheduledFlight;
import com.cg.fms.services.ScheduledFlightService;


@RestController
public class ScheduledFlightController {
	
	@Autowired
	ScheduledFlightService sfs;

	@PostMapping("/scheduledFlights")
	public ResponseEntity<ScheduledFlight> addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		ScheduledFlight sf = sfs.createScheduledFlight(scheduledFlight);
		ResponseEntity<ScheduledFlight> rEntity = new ResponseEntity<ScheduledFlight>(sf, HttpStatus.CREATED);
		return rEntity;
	}

	@GetMapping("/fetchScheduledFlights/{id}")
	public ResponseEntity<ScheduledFlight> showScheduledFlight(@PathVariable("id") long id) {
		ScheduledFlight sf = sfs.viewScheduledFlight(id);
		ResponseEntity<ScheduledFlight> rEntity = new ResponseEntity<ScheduledFlight>(sf, HttpStatus.FOUND);
		return rEntity;
	}

	@GetMapping("/fetchAllscheduledFlights")
	public ResponseEntity<List<ScheduledFlight>> viewScheduledFlights() {
		List<ScheduledFlight> sf = sfs.viewScheduledFlights();
		ResponseEntity<List<ScheduledFlight>> rEntity = new ResponseEntity<List<ScheduledFlight>>(sf, HttpStatus.FOUND);
		return rEntity;
	}

	@PutMapping("/scheduledFlights/{id}")
	public ResponseEntity<ScheduledFlight> updateScheduledFlight(@PathVariable("id") long id, @RequestBody ScheduledFlight scheduledFlight) {
		ScheduledFlight sf = sfs.modifyScheduledFlight(id,scheduledFlight);
		ResponseEntity<ScheduledFlight> rEntity = new ResponseEntity<ScheduledFlight>(sf, HttpStatus.FOUND);
		return rEntity;
	}

	@DeleteMapping("/deleteScheduledFlight/{id}")
	public ResponseEntity<String> deleteSchFlight(@PathVariable("id") long id) {
		String sf = sfs.deleteScheduledFlight(id);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(sf, HttpStatus.FOUND);
		return rEntity;
	}
}
