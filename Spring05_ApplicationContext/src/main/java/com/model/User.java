package com.model;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class User {
	String userid;
	String password;
	boolean loggedIn;
	
	@Autowired
	MessageSource messageSource;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void showStatus(Locale locale){
		String message = null;
		if(loggedIn){
//			System.out.println("valid "+this);
			message = this.messageSource.getMessage("valid", new Object[]{this.getUserid()}, "Welcome "+this.getUserid(), locale);
		} else {
//			System.out.println("invalid "+this);
			message = this.messageSource.getMessage("invalid", null, "Invalid details", locale);
		}
		System.out.println(message);
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password
				+ ", loggedIn=" + loggedIn + "]";
	}
	
}
