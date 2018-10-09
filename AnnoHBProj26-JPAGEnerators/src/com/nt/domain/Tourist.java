package com.nt.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Type;

@Entity
@Table(name="TOURIST")
public class Tourist implements Serializable {
	private int touristId;
	private String touristName;
	private String place;
	private Date doj;
	
	public Tourist() {
		System.out.println("Tourist:0-param constructor");
	}

	/*@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	
	/*@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	*/
	/*@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	@SequenceGenerator(name="gen1",sequenceName="JPA_SEQ",initialValue=100,allocationSize=5)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)*/
	
/*	@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	@TableGenerator(name="gen1",table="JPA_HILO",pkColumnName="PK_COL",pkColumnValue="PK_VAL",valueColumnName="HI_NEXT",initialValue=100,allocationSize=5)
	@GeneratedValue(generator="gen1",strategy=GenerationType.TABLE)
*/
	/*@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	
	/*@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	
	@Id
	@Column(name="TOURIST_ID")
	@Type(type="int")
	@TableGenerator(name="gen1",table="JPA_HILO",pkColumnName="PK_COL",pkColumnValue="PK_VAL",valueColumnName="HI_NEXT",initialValue=100,allocationSize=5)
	@GeneratedValue(generator="gen1",strategy=GenerationType.AUTO)
	
	public int getTouristId() {
		return touristId;
	}

	public void setTouristId(int touristId) {
		this.touristId = touristId;
	}

	@Column(name="TOURIST_NAME")
	@Type(type="string")
	public String getTouristName() {
		return touristName;
	}

	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	@Column(name="PLACE")
	@Type(type="string")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name="DOJ")
	@Type(type="date")
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

}
