package com.nt.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_details")
public class UserDetails implements Serializable{
	private int userId;
	private String firstName;
	private String address;
	private Set<PhoneNumber> phones;
	
	public UserDetails() {
		System.out.println("UserDetails::0-param constructor");
	}
	
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
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
	
	public Set<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	} 

}
