package com.nt.domain;

import java.io.Serializable;
import java.util.Date;

public class TicketDetails implements Serializable {
	private int aadharNo;
	private int ttktId;
	private String matchName;
	private Date  matchDate;
	private int price;
	
	public TicketDetails() {
		System.out.println("TicketDetails:0-param constructor");
	}
	
	
	public int getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}
	public int getTtktId() {
		return ttktId;
	}
	public void setTtktId(int ttktId) {
		this.ttktId = ttktId;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
