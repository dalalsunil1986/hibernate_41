package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Student1")
public class Student {
	private int sid;
	private String sname;
	private String sadd;
	private LibraryMembership libraryDetails;
	
	@Id
	@Column(length=5)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	
	@OneToOne(targetEntity=LibraryMembership.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="studentDetails")
	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

}
