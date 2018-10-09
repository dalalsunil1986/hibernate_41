package com.nt.domain;

import java.io.Serializable;

public class Department implements Serializable{
	private int deptNo;
	private String deptName;
	private String deptLoc;
	
	public Department() {
		System.out.println("Department:: 0-param constructor");
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

}
