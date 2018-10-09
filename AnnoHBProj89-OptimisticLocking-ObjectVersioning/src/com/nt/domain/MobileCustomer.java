package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name="MOBILECUSTOMER")
public class MobileCustomer implements Serializable {
	private int custId;
	private String custName;
	private long phoneNumber;
	private String callerTune;
	private int ver;
	
	@Id
	@Column(name="CUSTID",length=10)
	@Type(type="int")
	@SequenceGenerator(name="gen1",sequenceName="VER_SEQ",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	@Column(name="CUSTNAME",length=20)
	@Type(type="string")
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(name="PHONENUMBER",length=11)
	@Type(type="long")
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="CALLERTUNE",length=20)
	@Type(type="string")
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	
	@Column(name="VER_COL",length=5)
	@Type(type="int")
	@Version
	public int getVer() {
		return ver;
	}
	public void setVer(int ver) {
		this.ver = ver;
	}

}
