package com.cg.fms.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.dao.*;
import com.cg.fms.entities.*;
import com.cg.fms.exceptions.*;

@Service("userService")
public class UsersService {
	@Autowired
	UsersDao userDao;

	@Transactional

	public Users addUser(Users u) {
validateUser(u);
		return userDao.save(u);
	}

	@Transactional

	public Users updateUser(Users updateUser, long userId) {
		Optional<Users> findUserById = userDao.findById(updateUser.getId());
		if (findUserById.isPresent()) {
			userDao.save(updateUser);
		} else
			throw new UsersNotFoundException("User with Id: " + updateUser.getId() + " not exists!!");
		return updateUser;

	}

	@Transactional
	public Users viewUser(long userId) {
		Optional<Users> optus = userDao.findById(userId);
		if (!optus.isPresent())
			// throw exception if no user found
			throw new UsersNotFoundException("No user found with id " + userId);

		return optus.get();
	}

	public List<Users> viewUser() {
		return userDao.findAll();

	}

	@Transactional
	public String deleteUser(long userId) {
		String msg = "User with id " + userId + " was successfully deleted";
		Optional<Users> optus = userDao.findById(userId);
		if (!optus.isPresent()) {
			// return message if no user found
			return "No user found with id " + userId;
		}
		 userDao.deleteById(userId);
		return msg;
	}

	public void validateUser(Users flightUser) {
		// phone no should be of 10 digits & not start with 0
		// email's local part should have alphanumeric characters
		Long phoneNo = flightUser.getUserPhone();
		String phno = phoneNo.toString();
		Pattern p = Pattern.compile("^[1-9][0-9]{9}$");
		Matcher m = p.matcher(phno);
		String email = flightUser.getEmail();
		Pattern p1 = Pattern.compile("^[A-Za-z0-9]*@[a-zA-Z]+[.][a-zA-Z]{2,4}$");
		Matcher m1 = p1.matcher(email);
		if ((!m1.matches()) && (m.matches())) {
			throw new InvalidUserException("Email is invalid");
		} else if ((!m.matches()) && (m1.matches())) {
			throw new InvalidUserException("Phone number is invalid");
		} else if ((!m.matches()) && (!m1.matches())) {
			throw new InvalidUserException("Phone number and email are invalid");
		}

	}
}
