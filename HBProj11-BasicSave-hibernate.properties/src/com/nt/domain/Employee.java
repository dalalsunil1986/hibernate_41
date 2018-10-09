package com.nt.domain;

import java.io.Serializable;

public class Employee implements Serializable {
	private int eid;
	private String firstName;
	private String lastName;
	private String email;
	private Float salary;
	
	public Employee() {
	  System.out.println("Employee:0-param constructor");
	}
	
	public int getEid() {
		System.out.println("Employee::getEId()");
		return eid;
	}
	public void setEid(int eid) {
		System.out.println("Employee::setEId(-)");
		this.eid = eid;
	}
	public String getFirstName() {
		System.out.println("Employee::getFirstName()");
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("Employee::setFirstName(-)");
		this.firstName = firstName;
	}
	public String getLastName() {
		System.out.println("Employee::getLastName()");
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("Employee::setLastName()");
		this.lastName = lastName;
	}
	public String getEmail() {
		System.out.println("Employee::getEmail()");
		return email;
	}
	public void setEmail(String email) {
		System.out.println("Employee::setEmail(-)");
		this.email = email;
	}
	public Float getSalary() {
		System.out.println("Employee::getSalary()");
		return salary;
	}
	public void setSalary(Float salary) {
		System.out.println("Employee::setSalary()");
		this.salary = salary;
	}

}
