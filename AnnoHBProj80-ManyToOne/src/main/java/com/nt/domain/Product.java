package com.nt.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

@Entity
@Table
public class Product implements Serializable {
	private int proid;
	private String prodName;
	private int price;
	private ManufacturingCompany company;
	
	public Product() {
		System.out.println("Product:0-param constructor");
	}
	
	@Id
	@Column(length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
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
	@Type(type="int")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@ManyToOne(targetEntity=ManufacturingCompany.class,
			   cascade=CascadeType.ALL,
			   fetch=FetchType.EAGER)
	@JoinColumn(name="compId",referencedColumnName="compId")
	@LazyToOne(LazyToOneOption.PROXY)
	public ManufacturingCompany getCompany() {
		return company;
	}
	public void setCompany(ManufacturingCompany company) {
		this.company = company;
	}

}
