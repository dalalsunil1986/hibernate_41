package com.nt.domain;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
	private long phone;
	private String numberType;
	private String provider;
	private UserDetails user;
	
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public PhoneNumber() {
		System.out.println("PhoneNumber:0-param constructor");
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	

}
