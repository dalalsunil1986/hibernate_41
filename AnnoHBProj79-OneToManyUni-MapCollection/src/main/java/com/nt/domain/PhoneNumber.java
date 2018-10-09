package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PHONE_NUMBERS3")
public class PhoneNumber {
	private long phone;
	private String numberType;
	private String provider;

	@Id
	@Column(name="phone",length=10)
	@Type(type="long")
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	@Column(name="number_Type",length=10)
	@Type(type="string")
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	
	@Column(name="provider",length=10)
	@Type(type="string")
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	

}
