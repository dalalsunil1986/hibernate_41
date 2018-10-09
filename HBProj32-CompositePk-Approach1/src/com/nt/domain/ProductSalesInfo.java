package com.nt.domain;

import java.io.Serializable;

public class ProductSalesInfo implements Serializable {
	private int prodId;
	private int custId;
	private String prodName;
	private String custName;
	private float price;
	
	public ProductSalesInfo() {
	 System.out.println("ProductSalseInfo::0-param connstructor");
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
