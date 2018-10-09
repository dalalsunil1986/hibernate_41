package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class SavingObjectWithOutTxSupport {
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
	//prepare object
	policy=new InsurancePolicy();
	policy.setPolicyId(7889);
	policy.setPolicyName("JJ");
	policy.setCompany("LIC");
	policy.setTenure(80);
	policy.setPremium(90000);
	try{
	 idVal=(int) ses.save(policy);	
	 System.out.println("Policy Resitered and policy Id::"+idVal);
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
	
	}//main  	
}//class
