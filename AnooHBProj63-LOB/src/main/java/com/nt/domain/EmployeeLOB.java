package com.nt.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="EmployeeLOB")
public class EmployeeLOB implements Serializable {
	private int eid;
	private String ename;
	private Clob eresume;
	private Blob  ephoto;
	
	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Column(name="ENAME",length=20)
	@Type(type="string")
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Column(name="ERESUME")
	@Type(type="clob")
	public Clob getEresume() {
		return eresume;
	}
	public void setEresume(Clob eresume) {
		this.eresume = eresume;
	}
	
	@Column(name="EPHOTO")
	@Type(type="blob")
	public Blob getEphoto() {
		return ephoto;
	}
	public void setEphoto(Blob ephoto) {
		this.ephoto = ephoto;
	}

}
