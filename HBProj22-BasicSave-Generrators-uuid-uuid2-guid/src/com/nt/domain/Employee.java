package com.nt.domain;

import java.io.Serializable;

public class Employee implements Serializable {
	private String eid;
	private String firstName;
	private String lastName;
	private String email;
	private Float salary;
	
	public Employee() {
	  System.out.println("Employee:0-param constructor");
	}
	
	public String getEid() {
		
		return eid;
	}
	public void setEid(String eid) {
		
		this.eid = eid;
	}
	public String getFirstName() {
		
		return firstName;
	}
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	public String getLastName() {
		
		return lastName;
	}
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}
	public Float getSalary() {
		
		return salary;
	}
	public void setSalary(Float salary) {
		
		this.salary = salary;
	}

}
