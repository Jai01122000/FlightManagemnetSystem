package com.cg.fms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.AdminDao;
import com.cg.fms.entities.Admin;

@Service("as")
public class AdminService {
	@Autowired
	AdminDao ad;

	public String addAdmin(Admin admin) {
		
		Admin adm =  ad.save(admin);
		return "Admin Added Successfully";
	}
	
	public String authenticateAdmin(Admin admin) {
		
		Optional<Admin> opAdmin=ad.findById(admin.getAdminId());
		if(opAdmin.isPresent()) {
			Admin adm=opAdmin.get();
			if((admin.getAdminName().equals(adm.getAdminName()))&& admin.getAdminPassword().equals(adm.getAdminPassword()))
				return "Authenticated Successfully";
			else
				return "Incorrect Username or Password";
		}
		return null;
	}
}

