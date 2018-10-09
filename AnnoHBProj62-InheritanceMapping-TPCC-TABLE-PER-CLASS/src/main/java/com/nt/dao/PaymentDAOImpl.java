package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.CardPayment;
import com.nt.domain.CashPayment;
import com.nt.domain.ChequePayment;
import com.nt.domain.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void saveData() {
		Session ses=null;
		CardPayment cardPayment=null;
		CashPayment cashPayment=null;
		ChequePayment chequePayment=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		//save objects
		cardPayment=new CardPayment();
		cardPayment.setAmount(9000);
		cardPayment.setCardType("VISA");
		cardPayment.setCardNumber(1234567798);
		
		cashPayment=new CashPayment();
		cashPayment.setAmount(80000);
		cashPayment.setDenominations("20*2000,80*500");
		cashPayment.setLocation("hyd");
		
		chequePayment=new ChequePayment();
		chequePayment.setAmount(7000);
		chequePayment.setBankName("HDFC");
		chequePayment.setChequeNumber(98777668);
		try{
		 tx=ses.beginTransaction();
		  ses.save(cardPayment);
		  ses.save(chequePayment);
		  ses.save(cashPayment);
		 flag=true;
		}//try
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query1=null,query2=null,query3=null,query4=null;
		List<Payment> list1=null;
		List<ChequePayment> list2=null;
		List<CashPayment> list3=null;
		List<CardPayment> list4=null;
		//get Session 
		ses=HibernateUtil.getSession();
		
		//prepare and execute HQL Queries
		query1=ses.createQuery("from Payment");
		list1=query1.list();
		System.out.println("using Payment");
		list1.forEach(payment->{
			System.out.println(payment.getPaymentId()+" "+payment.getAmount());
		});
		System.out.println("---------------------------");
		query2=ses.createQuery("from ChequePayment");
		list2=query2.list();
		System.out.println("using ChequePayment");
		list2.forEach(payment->{
			System.out.println(payment.getPaymentId()+" "+payment.getAmount()+" "+payment.getBankName()+" "+payment.getChequeNumber());
		});

		System.out.println("------------------------------");
		query3=ses.createQuery("from CashPayment");
		list3=query3.list();
		System.out.println("using CashPayment");
		list3.forEach(payment->{
			System.out.println(payment.getPaymentId()+" "+payment.getAmount()+" "+payment.getDenominations()+" "+payment.getLocation());
		});
		
		System.out.println("------------------------------");
		query4=ses.createQuery("from CardPayment");
		list4=query4.list();
		System.out.println("using CardPayment");
		list4.forEach(payment->{
			System.out.println(payment.getPaymentId()+" "+payment.getAmount()+" "+payment.getCardNumber()+" "+payment.getCardType());
		});
		
		
	}

}//class
