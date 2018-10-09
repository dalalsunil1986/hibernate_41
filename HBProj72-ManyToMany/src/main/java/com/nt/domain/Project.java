package com.nt.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Project implements Serializable {
    private int projid;
    private String projname;
    private int teamsize;
    private Set<Programmer> programmers=new HashSet();
    
	public int getProjid() {
		return projid;
	}
	public void setProjid(int projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}
	
	
}
