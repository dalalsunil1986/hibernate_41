package com.nt.domain;

import java.io.Serializable;

public class EmpDetails implements Serializable {
	private int empNo;
	private String empName;
	private String empDesg;
	private Department dept;
	
	public EmpDetails() {
		System.out.println("EmpDetails::0-param construtor");
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

}
