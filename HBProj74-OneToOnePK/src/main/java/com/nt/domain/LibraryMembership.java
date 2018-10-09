package com.nt.domain;

import java.util.Date;

public class LibraryMembership {
	private int lib;
	private Date doj;
	private String membershipType;
	private Student studentDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembeship:0-param construtor");
	}

	public int getLib() {
		return lib;
	}

	public void setLib(int lib) {
		this.lib = lib;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public Student getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}

}
