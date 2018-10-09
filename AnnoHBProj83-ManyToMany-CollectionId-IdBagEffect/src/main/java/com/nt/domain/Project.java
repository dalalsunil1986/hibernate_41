package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="PROJECTS")
public class Project {
	private int projId;
	private String projName;
	private int teamSize;
	private Set<Programmer> programmers=new HashSet();
	
	@Id
	@GenericGenerator(name="gen1",strategy="sequence",parameters=@Parameter(name="sequence_name",value="proj_seq1"))
	@GeneratedValue(generator="gen1")
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	@ManyToMany(targetEntity=Programmer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="projects")
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}

}
