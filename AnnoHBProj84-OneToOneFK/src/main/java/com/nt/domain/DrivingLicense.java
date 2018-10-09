package com.nt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name="driving_license")
public class DrivingLicense {
	private int lid;
	private String type;
	private Date validFrom;
	private Date validTo;
	private Person licenseHolder;
	
	@Id
	@Column(name="lid",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="sequence",
	                  parameters=@Parameter(name="sequence_name",value="license_seq"))
	@GeneratedValue(generator="gen1")
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	@Column(name="type",length=10)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="validFrom")
	@Type(type="date")
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	
	@Column(name="validTo")
	@Type(type="date")
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	@OneToOne(targetEntity=Person.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="license_holder",referencedColumnName="pid")
	public Person getLicenseHolder() {
		return licenseHolder;
	}
	public void setLicenseHolder(Person licenseHolder) {
		this.licenseHolder = licenseHolder;
	}

}
