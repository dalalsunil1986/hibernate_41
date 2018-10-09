package com.nt.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

@Entity
@Table(name="user_details2")
public class UserDetails implements Serializable {
	private int userId;
	private String firstName;
	private String address;
	private List<PhoneNumber> phones;
	
	@Id
	@Column(name="userId",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="firstName",length=20)
	@Type(type="string")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="address",length=20)
	@Type(type="string")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@OneToMany(targetEntity=PhoneNumber.class,
			   cascade=CascadeType.ALL,
			   fetch=FetchType.LAZY,
			   orphanRemoval=true)
    @JoinColumn(name="unid",referencedColumnName="userId")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Fetch(FetchMode.JOIN)
	/*//@IndexColumn(name="LST_INDX",base=1)
	@OrderColumn(name="LST_INDX")
	@ListIndexBase(value=1)*/
	public List<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}

}
