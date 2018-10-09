package com.nt.domain;

import java.io.Serializable;

public class NGOMember implements Serializable {
	private int mid;
	private String firstName;
	private String lastName;
	
	
	
	public NGOMember() {
	  System.out.println("NGOMember:0-param constructor");
	}



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
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
	
	

}
