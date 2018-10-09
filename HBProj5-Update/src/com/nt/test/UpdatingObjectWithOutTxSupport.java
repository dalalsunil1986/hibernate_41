package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class UpdatingObjectWithOutTxSupport {
	public static void main(String[] args) {
		
	Configuration cfg=null;
	SessionFactory factory=null;
	Session ses=null;
	InsurancePolicy policy=null;
	Transaction tx=null;
	boolean flag=false;
	int idVal=0;
	//create Configuration object
	cfg=new Configuration();
	cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
	//create SessionFactory object
	factory=cfg.buildSessionFactory();
	//create Session
	ses=factory.openSession();
	//Load object
	policy=ses.get(InsurancePolicy.class,1001);
	if(policy!=null){
	try{
	  policy.setPremium(7000);	
	 ses.flush();
	}
	catch(HibernateException he){
		he.printStackTrace();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		//close objs
		ses.close();
		factory.close();
	}
	}//if
	}//main  	
}//class
