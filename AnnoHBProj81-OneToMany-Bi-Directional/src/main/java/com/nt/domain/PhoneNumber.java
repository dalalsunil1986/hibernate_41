package com.nt.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Phone_numbers")
public class PhoneNumber implements Serializable {
	private long phone;
	private String numberType;
	private String provider;
	private UserDetails user;
	
	@ManyToOne(targetEntity=UserDetails.class,
			   cascade=CascadeType.ALL,
			   fetch=FetchType.LAZY)
    @JoinColumn(name="unid",referencedColumnName="userId")	
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public PhoneNumber() {
		System.out.println("PhoneNumber:0-param constructor");
	}
	
	@Id
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	@Column(name="number_type")
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
