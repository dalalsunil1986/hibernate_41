package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Type;

@Table
@Entity
@FilterDefs(value=@FilterDef(name = "HB_INACTIVE_ACCOUNTS",
                             parameters={@ParamDef(name="acno1",type="int"),
                            		     @ParamDef(name="acno2",type="int"),
                            		     @ParamDef(name="acno3",type="int")
                                         }		 
                             )
           )
@Filters(value=@Filter(name="HB_INACTIVE_ACCOUNTS",
                       condition="ACNO NOT IN(:acno1,:acno2,:acno3)"
                      )
        )
public class AccountInfo implements Serializable{
	private int acno;
	private String holder;
	private  float balance;
	
	@Id
	@Column(length=10)
	@Type(type="int")
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	
	@Column(length=20,name="HOLDERNAME")
	@Type(type="string")
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	@Column(length=10,name="BALANCE",precision=2)
	@Type(type="float")
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}

}
