package com.service;

import com.dao.LoginDao;
import com.model.User;

public class LoginService {
	LoginDao loginDao;
	public LoginService(){ }
	public LoginService(LoginDao loginDao){ 
		this.loginDao = loginDao;
	}
	public User getLogin(User user){
		return this.loginDao.getLogin(user);
	}
}
