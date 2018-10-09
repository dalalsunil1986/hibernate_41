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
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="BSEStock2")
public class BSEStock implements Serializable {
	
	private int stockId;
	private String stockName;
	private float price;
	private int updationCount;
	private Timestamp  listedDate;
	private Timestamp  lastUpdated;
	
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
	
	@Column
	@Type(type="timestamp")
	@UpdateTimestamp
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated=lastUpdated;
	}
	
	@Column
	@Type(type="timestamp")
	@CreationTimestamp
	public Timestamp getListedDate() {
		return listedDate;
	}
	public void setListedDate(Timestamp listedDate) {
		this.listedDate = listedDate;
	}
	
	@Version
	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getUpdationCount() {
		return updationCount;
	}
	public void setUpdationCount(int updationCount) {
		this.updationCount = updationCount;
	}
	
	@Override
	public String toString() {
		return "BSEStock [stockId=" + stockId + ", stockName=" + stockName + ", price=" + price + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	

}
