package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Table(name="Employee")
@Entity
public class Employee implements Serializable {
	private int eid;
	private String firstName;
	private String lastName;
	private float salary;
	
	@Id
	@Column(length=6)
	@Type(type="int")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(length=7,precision=2)
	@Type(type="float")
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	

}
