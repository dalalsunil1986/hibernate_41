package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="INH_CASHPAYMENT3")
public class CashPayment extends Payment {
	private String denominations;
	private String location;
	
	@Column(length=15)
	@Type(type="string")
	public String getDenominations() {
		return denominations;
	}
	public void setDenominations(String denominations) {
		this.denominations = denominations;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
