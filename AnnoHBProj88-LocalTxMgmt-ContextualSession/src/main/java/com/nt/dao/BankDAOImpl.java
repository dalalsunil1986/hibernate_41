package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_QUERY="UPDATE Account SET balance=balance-:amt WHERE acno=:acid";
	private static final String DEPOSITE_QUERY="UPDATE Account SET balance=balance+:amt WHERE acno=:acid";

	 private int withdraw(int acno, int amt) {
		Session ses=null;
		Transaction tx=null;
		int count=0;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		System.out.println("withdraw session id::"+ses.hashCode());
		//prepare Query 
		query=ses.createQuery(WITHDRAW_QUERY);
		query.setInteger("amt",amt);
		query.setInteger("acid",acno);
       count=query.executeUpdate();
       return count;
	}

	
	public int deposite(int acno, int amt) {
		Session ses=null;
		Transaction tx=null;
		int count=0;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		System.out.println("deposite session id::"+ses.hashCode());
		//prepare Query 
		query=ses.createQuery(DEPOSITE_QUERY);
		query.setInteger("amt",amt);
		query.setInteger("acid",acno);
       count=query.executeUpdate();
       return count;
	}

	@Override
	public boolean transferMoney(int srcAcno, int destAcno, int amt) {
		boolean finalFlag=false;
		int count1=0,count2=0;
		Session ses=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		System.out.println("transferMoney session id::"+ses.hashCode());
		try{
		 tx=ses.beginTransaction();
		  count1=withdraw(srcAcno, amt);
		  count2=deposite(destAcno, amt);
		  if(count1==1 && count2==1 )
			  finalFlag=true;
		  else
			  finalFlag=false;
		}
		catch(HibernateException he){
			finalFlag=false;
		}
		finally{
			if(finalFlag)
				tx.commit();
			else
				tx.rollback();
		}
		
		return finalFlag;
	}

}
