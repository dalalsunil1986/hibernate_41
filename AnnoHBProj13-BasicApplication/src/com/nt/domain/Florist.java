package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
//@Table(name="FLORIST")
public class Florist implements Serializable {
	private int flowerId;
	private String flowerName;
	private int qtry;
	private float price;
	//@Transient
	private String status;
	
	public Florist() {
		System.out.println("Florist:0-param constructor");
	}
	
	
	@Id
	//@Column(name="FLOWERID",length=5)
	@Type(type="int")
	public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}
	
	@Column(name="FLOWERNAME",length=20,unique=true,nullable=false)
	@Type(type="string")
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	
	@Column(name="QUANITY",length=10)
	@Type(type="int")
	public int getQtry() {
		return qtry;
	}
	public void setQtry(int qtry) {
		this.qtry = qtry;
	}
	
	@Column(name="PRICE",length=10,precision=2,nullable=false)
	@Type(type="float")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column(name="STATUS",length=10,nullable=false)
	@Type(type="string")
	@Transient
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 

/*	SQL> create table Florist(flowerId number(5) primary key,flowerName varchar2(10),quanity number(10),price number(10,2),status varchar(10));
*/	
}
