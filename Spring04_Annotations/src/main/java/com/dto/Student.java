package com.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
	private Address address;
	
	public void setAddress(Address address){
		this.address = address;
	}
	public Address getAddress() {
		return this.address;
	}
	@Override
	public String toString() {
		return "Student [address=" + address + "]";
	}
	
}