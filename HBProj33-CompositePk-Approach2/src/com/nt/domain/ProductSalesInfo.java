package com.nt.domain;

import java.io.Serializable;

public class ProductSalesInfo implements Serializable {
	private ProdCustId cid;
	
	private String prodName;
	private String custName;
	private float price;
	
	public ProductSalesInfo() {
	 System.out.println("ProductSalseInfo::0-param connstructor");
	}
	
	public ProdCustId getCid() {
		return cid;
	}


	public void setCid(ProdCustId cid) {
		this.cid = cid;
	}
	

	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
