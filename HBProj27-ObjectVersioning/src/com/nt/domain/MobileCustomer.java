package com.nt.domain;

import java.io.Serializable;

public class MobileCustomer implements Serializable {
	private int custId;
	private String custName;
	private long phoneNumber;
	private String callerTune;
	private int ver;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public int getVer() {
		return ver;
	}
	public void setVer(int ver) {
		this.ver = ver;
	}

}
