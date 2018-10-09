package com.nt.domain;
// Generated Apr 13, 2018 5:46:20 PM by Hibernate Tools 5.1.4.Final

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="IPL_MATCH_INFO")
@NamedQueries(value={@NamedQuery(name = "GET_ALL_MATCHES", query = "from IplMatchInfo"),
		@NamedQuery(name = "UPDATE_MATCH_LOC", query = "update IplMatchInfo set location=:newloc where location=:oldloc")
             })

public class IplMatchInfo implements java.io.Serializable {

	private int matchid;
	private String title;
	private String location;
	private Timestamp matchDate;
	private String finalresult;
	
	

	public IplMatchInfo() {
		System.out.println("IplMatchInfo::0-param constructor");
	}

	public IplMatchInfo(int matchid) {
		this.matchid = matchid;
	}

	public IplMatchInfo(int matchid, String title, String location, Timestamp matchDate, String finalresult) {
		this.matchid = matchid;
		this.title = title;
		this.location = location;
		this.matchDate = matchDate;
		this.finalresult = finalresult;
	}

	@Id
	@Column(length=10)
	@Type(type="int")
	public int getMatchid() {
		return this.matchid;
	}

	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}

	@Column(length=10)
	@Type(type="string")
	public String getTitle() {
		return this.title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length=10)
	@Type(type="string")
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column
	@Type(type="timestamp")
	public Timestamp getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Timestamp matchDate) {
		this.matchDate = matchDate;
	}

	@Column(length=10)
	@Type(type="string")
	public String getFinalresult() {
		return this.finalresult;
	}

	public void setFinalresult(String finalresult) {
		this.finalresult = finalresult;
	}

}
