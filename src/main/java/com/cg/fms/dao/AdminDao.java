package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Admin;

@Repository("ad")
public interface AdminDao extends JpaRepository<Admin , Integer> {


}