package com.dao;

import com.model.User;

public class LoginDao {
	
	public User getLogin(User user){
		// get user from database
		user.setLoggedIn(user.getUserid().equals(user.getPassword()));
		return user;
	}
}
