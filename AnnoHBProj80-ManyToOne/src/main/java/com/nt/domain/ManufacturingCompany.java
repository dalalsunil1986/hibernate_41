package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Table(name="ManufacturingCompany")
@Entity
public class ManufacturingCompany {
	private int compId;
	private String compName;
	private String compAddrs;
	
	public ManufacturingCompany() {
		System.out.println("ManufacturingCompany::0-param constructor");
	}
	
	@Id
	@Column(length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="sequence",parameters=@Parameter(name="sequence_name",value="comp_seq"))
	@GeneratedValue(generator="gen1")             
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getCompAddrs() {
		return compAddrs;
	}
	public void setCompAddrs(String compAddrs) {
		this.compAddrs = compAddrs;
	}
}//class
