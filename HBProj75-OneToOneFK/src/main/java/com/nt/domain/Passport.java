package com.nt.domain;

public class Passport {
	private int psptNo;
	private String country;
	private String psptType;
	private Person psptHolder;
	
	public int getPsptNo() {
		return psptNo;
	}
	public void setPsptNo(int psptNo) {
		this.psptNo = psptNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPsptType() {
		return psptType;
	}
	public void setPsptType(String psptType) {
		this.psptType = psptType;
	}
	public Person getPsptHolder() {
		return psptHolder;
	}
	public void setPsptHolder(Person psptHolder) {
		this.psptHolder = psptHolder;
	}

}
