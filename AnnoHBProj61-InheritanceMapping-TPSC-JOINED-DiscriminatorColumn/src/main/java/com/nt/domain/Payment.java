package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="INH_PAYMENT2D")
@DiscriminatorColumn(name="Payment_type",
                     length=10,
                     discriminatorType=DiscriminatorType.STRING)
public abstract class Payment {
	private int paymentId;
	private float amount;
	
	@Id
	@Column(length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(length=10,precision=2)
	@Type(type="float")
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
