package com.nt.domain;

public class Customer extends Person {
	private String address;
	private float billAmt;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}

}
