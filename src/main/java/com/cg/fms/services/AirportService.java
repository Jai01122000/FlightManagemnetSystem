package com.cg.fms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.AirportDao;
import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.AirportCodeNotFoundException;
import com.cg.fms.exceptions.NoAirportsFoundException;

@Service("airportService")
public class AirportService{
	@Autowired
	AirportDao airportDao;
	
	
	
	public Iterable<Airport> viewAllAirport() {
		Iterable<Airport> alist = airportDao.findAll();
		if(alist == null) {
			throw new NoAirportsFoundException("No Aiport found");
		}
		return alist;
	}
	public Airport viewAirportByCode(String airportCode) {
		java.util.Optional<Airport> opId = airportDao.findById(airportCode);
		if (opId.isPresent()) {
			return opId.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new AirportCodeNotFoundException("Airport with airport code: " + airportCode + "not exists");
	    }
	
}