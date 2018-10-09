package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Employee")
public class Employee implements Serializable {
	private int eid;
	private String firstName;
	private String lastName;
	private String email;
	private Float salary;
	
	public Employee() {
	  System.out.println("Employee:0-param constructor");
	}
	
	/*@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")*/
	
	/*@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="identity")
	@GeneratedValue(generator="gen1")*/
	
/*	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="sequence",
	                  parameters=@Parameter(name="sequence_name",value="NIT_SEQ")
	                  )
*/	
	
/*	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="sequence" )
	@GeneratedValue(generator="gen1")
*/
	
	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="seqhilo",
	                  parameters={@Parameter(name="sequence_name",value="NIT_SEQ"),
	                		      @Parameter(name="max_lo",value="5")
	                             }
	                  )
	@GeneratedValue(generator="gen1")
	public int getEid() {
		
		return eid;
	}
	public void setEid(int eid) {
		
		this.eid = eid;
	}
	@Column(name="FIRSTNAME",length=20)
	@Type(type="string")
	public String getFirstName() {
		
		return firstName;
	}
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	@Column(name="LASTNAME",length=20)
	@Type(type="string")
	public String getLastName() {
		
		return lastName;
	}
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	@Column(name="EMAIL",length=20)
	@Type(type="string")
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	@Column(name="SALARY",length=10,precision=2)
	@Type(type="float")
	public Float getSalary() {
		
		return salary;
	}
	public void setSalary(Float salary) {
		
		this.salary = salary;
	}

}
