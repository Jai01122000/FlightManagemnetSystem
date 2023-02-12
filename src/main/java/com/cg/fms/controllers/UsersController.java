package com.cg.fms.controllers;

import com.cg.fms.entities.*;
import com.cg.fms.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@RestController
public class UsersController {

	@Autowired
	UsersService userService;

	@PostMapping(value = "/users")
	public ResponseEntity<Users> addUser(@Valid @RequestBody Users User) {
		Users ur = userService.addUser(User);
		ResponseEntity<Users> rEntity = new ResponseEntity<Users>(ur, HttpStatus.CREATED);
		return rEntity;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Users> viewUser(@PathVariable("id") long userId) {

		Users ur = userService.viewUser(userId);
		ResponseEntity<Users> rEntity = new ResponseEntity<Users>(ur, HttpStatus.FOUND);
		return rEntity;
	}

	@GetMapping("/users")
	public ResponseEntity<List<Users>> viewUser() {
		List<Users> alist = userService.viewUser();
		ResponseEntity<List<Users>> rEntity = new ResponseEntity<List<Users>>(alist, HttpStatus.FOUND);
		return rEntity;
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users newU, @PathVariable("id") long userId) {
		Users ur = userService.updateUser(newU, userId);
		ResponseEntity<Users> rEntity = new ResponseEntity<Users>(ur, HttpStatus.ACCEPTED);
		return rEntity;
	}

	@DeleteMapping("/users/{id}")
	public  String deleteUser(@PathVariable("id") long userId){
	    String result = userService.deleteUser(new Long(userId));
	    return result;
	}

	@GetMapping("/users/flights/{fno}")
	public List<Flight> viewFlight(@PathVariable("fno") long fno) {
		String url = "http://localhost:8085/flights";
		RestTemplate rt = new RestTemplate();
		List<Flight> list = Arrays.asList(rt.getForObject(url, Flight[].class));
		return list;
	}
	
	@GetMapping("/users/flights")
	public List<Flight> viewAllFlight(){
		String url = "http://localhost:8085/flights";
		RestTemplate rt = new RestTemplate();
		List<Flight> list = Arrays.asList(rt.getForObject(url, Flight[].class));
		return list;
		}


	
	
	@GetMapping("users/scheduledFlights")
	public List<ScheduledFlight> ViewScheduledFlightss(){
		String url = "http://localhost:8085/fetchAllscheduledFlights";
		RestTemplate rt = new RestTemplate();
		List<ScheduledFlight> list = Arrays.asList(rt.getForObject(url, ScheduledFlight[].class));
		return list;
	}


}
