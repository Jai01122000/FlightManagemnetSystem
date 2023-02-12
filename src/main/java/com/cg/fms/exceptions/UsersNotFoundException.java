package com.cg.fms.exceptions;

public class UsersNotFoundException extends RuntimeException {
	public UsersNotFoundException (String msg) {
		super(msg);
	}

}
