package com.tkhts.relationship;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private double sal;
	@ManyToMany
	Collection<Dept> dept= new ArrayList<Dept>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + ", dept="
				+ dept + "]";
	}
	public Collection<Dept> getDept() {
		return dept;
	}
	public void setDept(Collection<Dept> dept) {
		this.dept = dept;
	}
	


}
