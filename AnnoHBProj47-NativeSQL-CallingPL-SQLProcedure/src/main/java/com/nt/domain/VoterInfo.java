package com.nt.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;

//import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Type;

@Entity
/*@NamedNativeQuery(name = "CALL_PROCEDURE", 
                  query = "{call P_GET_VOTERS_INFO_BY_RANGE(?,?,?)}",
                  callable=true,
                  resultClass=VoterInfo.class)
*/
@NamedNativeQuery(name="CALL_PROCEDURE",
                   query="{call P_GET_VOTERS_INFO_BY_RANGE(?,:min,:max)}",
                   hints=@QueryHint(name = "org.hibernate.Callable", value = "true"),
                   resultClass=VoterInfo.class)

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
