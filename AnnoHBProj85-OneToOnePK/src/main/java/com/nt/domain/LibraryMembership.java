package com.nt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
@Entity
public class LibraryMembership {
	private int lid;
	private String type;
	private Date doj; 
	private Student studentDetails;
	
	@Id
	@Column(length=5)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="foreign",
	       parameters=@Parameter(name="property",value="studentDetails"))
	@GeneratedValue(generator="gen1")
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	@Column(length=10)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Type(type="date")
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="lid",referencedColumnName="sid")
	public Student getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}

}
