package com.cg.fms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class Admin {
	@Id
	int adminId;
	
	String adminName;
	
	String adminPassword;

}