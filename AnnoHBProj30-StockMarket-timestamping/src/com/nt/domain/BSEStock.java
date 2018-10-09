package com.nt.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="BSEStock1")
public class BSEStock implements Serializable {
	
	private int stockId;
	private String stockName;
	private float price;
	private Timestamp  lastUpdated=new Timestamp(new Date().getTime());
	
	@Id
	@Column(length=10)
	@Type(type="int")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	@Column(length=20,nullable=false,unique=true)
	@Type(type="string")
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	@Column(length=10,precision=2,nullable=false)
	@Type(type="float")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column(nullable=false)
	@Type(type="timestamp")
	//@Temporal(value=TemporalType.DATE)
	@UpdateTimestamp
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated=lastUpdated;
	}
	
	@Override
	public String toString() {
		return "BSEStock [stockId=" + stockId + ", stockName=" + stockName + ", price=" + price + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	

}
