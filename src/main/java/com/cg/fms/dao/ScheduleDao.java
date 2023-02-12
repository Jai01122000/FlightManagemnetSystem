package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Schedule;
@Repository("sdao")
public interface ScheduleDao extends JpaRepository<Schedule, Long>{
	
}