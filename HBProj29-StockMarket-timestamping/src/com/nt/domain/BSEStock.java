package com.nt.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BSEStock implements Serializable {
	private int stockId;
	private String stockName;
	private float price;
	private Timestamp  lastUpdated;
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	@Override
	public String toString() {
		return "BSEStock [stockId=" + stockId + ", stockName=" + stockName + ", price=" + price + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	

}
