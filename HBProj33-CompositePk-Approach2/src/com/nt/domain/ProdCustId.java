package com.nt.domain;

import java.io.Serializable;

public class ProdCustId implements Serializable {
	private int prodId;
	private int custId;
	
	public ProdCustId() {
		System.out.println("ProdCustId::0-param constructor");
	}
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

}
