package com.nt.domain;

import java.io.Serializable;
import java.util.Date;

public class VoterInfo implements Serializable {
	private int voterId;
	private String voterName;
	private Date dob;
	private String mlaDiv;
	private String mpDiv;
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMlaDiv() {
		return mlaDiv;
	}
	public void setMlaDiv(String mlaDiv) {
		this.mlaDiv = mlaDiv;
	}
	public String getMpDiv() {
		return mpDiv;
	}
	public void setMpDiv(String mpDiv) {
		this.mpDiv = mpDiv;
	}

}
