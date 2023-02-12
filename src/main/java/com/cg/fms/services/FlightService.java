package com.cg.fms.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fms.dao.FlightDao;
import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.FlightNotFoundException;

@Service("flightService")
@Transactional
public class FlightService {
	
	@Autowired
	FlightDao fDao;
	
	
	public Flight createNewFlight(Flight flight) {
		
		return fDao.save(flight);
	}
	
	
	public Flight updateFlight(Flight flight) { 
		Optional<Flight> flt = fDao.findById(flight.getFlightNumber());		
		if(!flt.isPresent())
		{
			//throw exception if flight not found
			throw new FlightNotFoundException("No flight found with flight number "+flight.getFlightNumber());
		}
		Flight f = flt.get();
     	f.setFlightNumber(f.getFlightNumber());
		f.setCarrierName(f.getCarrierName());
		f.setFlightModel(f.getFlightModel());
		return fDao.save(flight);
	}
	
	
	
	public Flight viewFlight(long fno) throws FlightNotFoundException {
		Optional<Flight> flt = fDao.findById(fno);
		if(!flt.isPresent())
		{
			//throw exception if flight not found
			throw new FlightNotFoundException("No flight found with flight number "+fno);
		}
		return flt.get();
		
	}
	
	public List<Flight> viewFlights() {
		
		return fDao.findAll();
	}
    
	public String deleteFlight(long fno) {
		Optional<Flight> flt = fDao.findById(fno);
		if(!flt.isPresent())
		{
			//throw exception if flight not found
		throw new FlightNotFoundException("No flight found with flight number "+fno);
			
			
		}
		else {
//			throw new FlightNotFoundException("No Record Found with id - "+ fno +" To Delete");
			fDao.deleteById(fno);
			return "Deletion Success of Flight Number: "+ fno;
		}
	}
	
}