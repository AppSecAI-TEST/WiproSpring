package com.dto;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Item {
	String name;
	Date manufacturingDate;
	
	@Autowired(required=false)
	@Qualifier("moto")
	Company manufacturedCompany;
	
	@Resource (name= "receipt")//by-name autowiring 
	Invoice invoice;

	
	@PostConstruct
		public void init(){
		System.out.println("after construction");
	}
	@PreDestroy
		public void destroy(){
		System.out.println("before destroy");
	}
	
	
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	@Required
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	
	public Company getManufacturedCompany() {
		return manufacturedCompany;
	}
	public void setManufacturedCompany(Company manufacturedCompany) {
		this.manufacturedCompany = manufacturedCompany;
	}
	
	
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", manufacturingDate="
				+ manufacturingDate + ", manufacturedCompany="
				+ manufacturedCompany + ", invoice=" + invoice + "]";
	}
	
}
