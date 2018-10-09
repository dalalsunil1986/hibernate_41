package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity
@DiscriminatorValue("card")
public class CardPayment extends Payment {
    private long cardNumber;
    private String cardType;
    
    @Column(length=17)
    @Type(type="long")
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
