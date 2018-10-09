package com.nt.domain;

import java.io.Serializable;
import java.util.Set;

public class UserDetails implements Serializable{
	private int userId;
	private String firstName;
	private String address;
	private Set<PhoneNumber> phones;
	
	public UserDetails() {
		System.out.println("UserDetails::0-param constructor");
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	} 

}
