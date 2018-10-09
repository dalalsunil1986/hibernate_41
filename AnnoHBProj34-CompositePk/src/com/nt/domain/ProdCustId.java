package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class ProdCustId implements Serializable {
	private int prodId;
	private int custId;
	
	public ProdCustId() {
		System.out.println("ProdCustId::0-param constructor");
	}
	
	
	@Column(length=7)
	@Type(type="int")
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	@Column(length=7)
	@Type(type="int")
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

}
