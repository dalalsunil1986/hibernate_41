package com.nt.domain;

import java.io.Serializable;

public class Student implements Serializable {
	private int sno;
	private String sname;
	private String sadd;
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
	

}
