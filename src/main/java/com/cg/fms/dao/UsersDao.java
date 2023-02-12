package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.*;

@Repository("userDao")
public interface UsersDao extends JpaRepository<Users,Long> {
	
}

