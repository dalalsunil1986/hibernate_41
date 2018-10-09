package com.nt.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Project implements Serializable {
    private int projid;
    private String projname;
    private int teamsize;
    private List<Programmer> programmers=new ArrayList();
    
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
	public List<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}
	
	
}
