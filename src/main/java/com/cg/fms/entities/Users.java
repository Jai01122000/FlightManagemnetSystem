package com.cg.fms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "type")
	private String userType;

	@Column(name = "name")
	@NotEmpty
	private String userName;

	@Column(name = "pwd")
	@NotEmpty
	private String userPassword;

	@Column(name = "phno")
	@Size(min = 10, max = 10)
	private long userPhone;

	@Column(name = "email")
	@Email
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	List<Booking> booking = new ArrayList<>();

	public Users(long id, String userType, @NotEmpty String userName, @NotEmpty String userPassword,
			@Size(min = 10, max = 10) long userPhone, @Email String email) {
		super();
		this.id = id;
		this.userType = userType;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.email = email;
	}
}
