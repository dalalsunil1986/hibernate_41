package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="ProductSalesInfo")
public class ProductSalesInfo implements Serializable {
	private ProdCustId cid;
	private String prodName;
	private String custName;
	private float price;
	
	public ProductSalesInfo() {
	 System.out.println("ProductSalseInfo::0-param connstructor");
	}
	
	@EmbeddedId
	public ProdCustId getCid() {
		return cid;
	}


	public void setCid(ProdCustId cid) {
		this.cid = cid;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
	@Column(length=10,precision=2)
	@Type(type="float")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
