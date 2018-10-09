package com.nt.vo;

import java.io.Serializable;
import java.util.Date;
public class LibraryMembershipVO {
	private String type;
	private StudentVO studentDetails;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public StudentVO getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentVO studentDetails) {
		this.studentDetails = studentDetails;
	}

}
