package com.nt.dto;

import java.io.Serializable;

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

public class StudentDTO implements Serializable {
	private int sid;
	private String sname;
	private String sadd;
	private LibraryMembershipDTO libraryDetails;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	
	public LibraryMembershipDTO getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembershipDTO libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

}
