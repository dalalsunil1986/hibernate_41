package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity
@DiscriminatorValue("cheque")
public class ChequePayment extends Payment {
	private  long chequeNumber;
	private  String bankName;
	
	@Column(length=12)
	@Type(type="long")
	public long getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
