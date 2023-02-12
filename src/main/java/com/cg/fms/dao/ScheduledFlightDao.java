package com.cg.fms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.ScheduledFlight;
@Repository("sfdao")
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, Long>{
	

}
