package com.nt.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.Type;

@Entity
@NamedNativeQueries(value = {@NamedNativeQuery(name = "GET_ALL_VOTERS", query = "SELECT * FROM VOTERINFO",resultClass=VoterInfo.class),
		                     @NamedNativeQuery(name = "GET_VOTERS_COUNT", query = "SELECT COUNT(*) FROM VOTERINFO")
                             }
                    )
public class VoterInfo implements Serializable {
	private int voterId;
	private String voterName;
	private Date dob;
	private String mlaDiv;
	private String mpDiv;
	
	@Id
	@Column(length=10)
	@Type(type="int")
	public int getVoterId() {
		return voterId;
	}
	
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	
	@Column
	@Type(type="date")
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getMlaDiv() {
		return mlaDiv;
	}
	public void setMlaDiv(String mlaDiv) {
		this.mlaDiv = mlaDiv;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getMpDiv() {
		return mpDiv;
	}
	public void setMpDiv(String mpDiv) {
		this.mpDiv = mpDiv;
	}

}
