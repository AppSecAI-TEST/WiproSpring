package com.dto;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private String city;
	
	public void setCity(String city){
		this.city = city;
	}
    public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
    
}