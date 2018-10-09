package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable {
	private int projId;
	private String projName;
	private int teamSize;
	private int period;
	
	@Id
	@Column(name="PROJID",length=5)
	@Type(type="int")
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	
	@Column(name="PROJNAME",length=20,nullable=false)
	@Type(type="string")
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	@Column(name="teamSize",length=5,nullable=true)
	@Type(type="int")
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	@Column(name="period",length=5,nullable=false)
	@Type(type="int")
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	

}
