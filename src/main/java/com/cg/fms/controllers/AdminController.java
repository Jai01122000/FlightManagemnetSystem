package com.cg.fms.controllers;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;

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
import org.springframework.web.client.RestTemplate;

import com.cg.fms.entities.Admin;
import com.cg.fms.entities.Flight;
import com.cg.fms.entities.Schedule;
import com.cg.fms.services.AdminService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired
	AdminService as;
	
	

	
	@Operation(summary="To add Admin")
	@PostMapping("/admins")
	public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin) {
		String msg = as.addAdmin(admin);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}

	// Controller method to authenticateAdmin
	@Operation(summary = "To login with Correct Id and Password")
	@PostMapping("/authenticate")
	public String authenticateAdmin(@Valid @RequestBody Admin admin) {
		return as.authenticateAdmin(admin);
	}
	
	
	@Autowired
	RestTemplate rt;
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		String url = "http://localhost:8085/flights";
		ResponseEntity<Flight> rEntity = rt.postForEntity(url, flight, Flight.class);
		return rEntity;
	
}

	@GetMapping("/flights")
	public List<Flight> viewFlight(){
		String url = "http://localhost:8085/flights";
		List<Flight> list = Arrays.asList(rt.getForObject(url, Flight[].class));
		
		return list;
}

	@GetMapping("/flights/{fno}")
	public ResponseEntity<Flight> viewFlightById(@PathVariable("fno") long fno){
		String url = "http://localhost:8085/flights/ "+fno;
		ResponseEntity<Flight> list = rt.getForEntity(url, Flight.class);
		return list;
}
	@DeleteMapping("/flights/{fno}")
	public String deleteFlight(@PathVariable("fno") long  fno){
		String url = "http://localhost:8085/flights/"+fno;
		rt.delete(url,fno);
		return "Deleted";
}
	@PutMapping("/flights/{fno}")
	public String updateFlight(@PathVariable("fno") long fno ,@RequestBody Flight flight){
		String url = "http://localhost:8085/flights/ "+fno;
		//RestTemplate rt = new RestTemplate();
		rt.put(url,flight);
		return "Updated Successfully";
}
	@PostMapping("/schedules")
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
		String url = "http://localhost:8085/schedules";
		ResponseEntity<Schedule> rEntity = rt.postForEntity(url, schedule, Schedule.class);
		return rEntity;
	
	}
	@GetMapping("/schedules")
	public List<Schedule> viewAllSchedule(){
		String url = "http://localhost:8085/schedules";
		List<Schedule> list = Arrays.asList(rt.getForObject(url, Schedule[].class));
		
		return list;
}
	@GetMapping("/schedules/{sid}")
	public ResponseEntity<Schedule> viewScheduleBySid(@PathVariable("sid") long sid){
		String url = "http://localhost:8085/schedules/"+sid;
		ResponseEntity<Schedule> list = rt.getForEntity(url, Schedule.class);
		
		return list;
}
	@PutMapping("/schedules/{sid}")
	public String updateSchedule(@PathVariable("sid") long sid,@RequestBody Schedule schedule){
		String url = "http://localhost:8085/schedules/"+sid;
		//RestTemplate rt = new RestTemplate();
		rt.put(url,schedule);
		return "Updated Successfully";
		}
	
	@DeleteMapping("/schedules/{sid}")
	public String deleteSchedule(@PathVariable long sid){
		String url = "http://localhost:8085/schedules/"+sid;
		rt.delete(url);
		return "Deleted";
	
}
}
	
