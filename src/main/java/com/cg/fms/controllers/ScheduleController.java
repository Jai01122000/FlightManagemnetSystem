package com.cg.fms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.*;
import com.cg.fms.services.ScheduleService;


@Repository
@RestController
@RequestMapping("/schedules")
public class ScheduleController {
	@Autowired
	ScheduleService ss;
	
	@PostMapping
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
		Schedule sc = ss.createSchedule(schedule);
		ResponseEntity<Schedule> rEntity = new ResponseEntity<Schedule>(sc, HttpStatus.CREATED);
		return rEntity;
	}
	
	@GetMapping("/{sid}")
	public ResponseEntity<Schedule> viewScheduleBySId(@PathVariable("sid") long sid) {
		Schedule sc = ss.viewSchedule(sid);
		ResponseEntity<Schedule> rEntity = new ResponseEntity<Schedule>(sc, HttpStatus.FOUND);

		return rEntity;
	}
	
	@GetMapping
	public ResponseEntity<List<Schedule>> viewAllSchedule(){
		List<Schedule> sc = ss.viewAllSchedule();
		ResponseEntity<List<Schedule>> rEntity = new ResponseEntity<List<Schedule>>(sc, HttpStatus.FOUND);

		return rEntity;
	}
	
	@PutMapping("/{sid}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable("sid") long sid,@RequestBody Schedule schedule) {
		Schedule sc = ss.modifySchedule(sid, schedule);
		ResponseEntity<Schedule> rEntity = new ResponseEntity<Schedule>(sc, HttpStatus.FOUND);

		return rEntity;
	}
	
	@DeleteMapping("/{sid}")
	public ResponseEntity<String> deleteBooking(@PathVariable ("sid") long sid)
	{
		String sc =ss.deleteSchedule(sid);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(sc,HttpStatus.FOUND);
		return rEntity;

	}
}