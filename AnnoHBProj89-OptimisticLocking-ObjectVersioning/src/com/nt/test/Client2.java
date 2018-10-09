package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.MobileCustomer;
import com.nt.utility.HibernateUtil;

public class Client2 {

	public static void main(String[] args){
		Session ses=null;
		MobileCustomer customer=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load object
		customer=ses.get(MobileCustomer.class,100);
		
		try{
		 tx=ses.beginTransaction();
		 customer.setCallerTune("ring.. ring...");
		 ses.update(customer);
		 flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//method
}//class
