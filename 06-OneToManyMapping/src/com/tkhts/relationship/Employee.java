package com.tkhts.relationship;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int emp_id;
	private String name;
	private double sal;
	
	@OneToMany
	@JoinTable(name="emp_dept",joinColumns=@JoinColumn(name="emp_id"),inverseJoinColumns=@JoinColumn(name="deptid"))
	Collection<Dept> dept = new ArrayList<Dept>();
	
	public int getId() {
		return emp_id;
	}
	public void setId(int id) {
		this.emp_id = id;
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
		return "Emp [id=" + emp_id + ", name=" + name + ", sal=" + sal + ", dept="
				+ dept + "]";
	}
	public Collection<Dept> getDept() {
		return dept;
	}
	public void setDept(Collection<Dept> dept) {
		this.dept = dept;
	}
	

}
