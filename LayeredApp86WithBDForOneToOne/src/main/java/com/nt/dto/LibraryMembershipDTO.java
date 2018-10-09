package com.nt.dto;

import java.io.Serializable;
import java.util.Date;
public class LibraryMembershipDTO implements Serializable {
	private int lid;
	private String type;
	private Date doj; 
	private StudentDTO studentDetails;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public StudentDTO getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDTO studentDetails) {
		this.studentDetails = studentDetails;
	}

}
