package com.nt.domain;

public class SocialRanking {
	private int sno;
	private long aadharNo;
	private String personName;
	private String address;
	private int socialRank;
	
	public SocialRanking() {
		System.out.println("SocialRanking:0-param constructor");
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSocialRank() {
		return socialRank;
	}
	public void setSocialRank(int socialRank) {
		this.socialRank = socialRank;
	}
	

}
