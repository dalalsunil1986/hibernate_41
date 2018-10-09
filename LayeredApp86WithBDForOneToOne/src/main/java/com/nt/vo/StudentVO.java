package com.nt.vo;

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

public class StudentVO  {
	private String sname;
	private String sadd;
	private LibraryMembershipVO libraryDetails;
	
	
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
	
	public LibraryMembershipVO getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembershipVO libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

}
