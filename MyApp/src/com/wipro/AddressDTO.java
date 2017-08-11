package com.wipro;

public class AddressDTO {
	private String city;
	private long pin;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "AddressDTO [city=" + city + ", pin=" + pin + "]";
	}
	
	
}
