package com.cg.fms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Flight;


@Repository("fDao")
public interface FlightDao extends JpaRepository<Flight, Long>{
	
}
