package com.wipro;

import java.util.Date;

public class UserDTO {
	
	private String fName;
	private String lName;
	private String email;
	private String password;
	private Date dob;
	private String gender;
	
	private AddressDTO address;
	
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserDTO [fName=" + fName + ", lName=" + lName + ", email="
				+ email + ", password=" + password + ", dob=" + dob
				+ ", gender=" + gender + ", address=" + address + "]";
	}


	
	
	
	
}
