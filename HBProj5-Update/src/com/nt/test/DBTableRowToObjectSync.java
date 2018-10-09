package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class DBTableRowToObjectSync {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		Transaction tx=null;
		boolean flag=false;
		//create Configuration object
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory object
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//Load object
		policy=ses.get(InsurancePolicy.class,1001);
		System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+" "+policy.getCompany()+"  "+policy.getTenure());
		try{
		Thread.sleep(30000);  //during this period modify db table record
		}
		catch(Exception e){ }
        ses.refresh(policy);		
		System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+" "+policy.getCompany()+"  "+policy.getTenure());
		
		
		}//main
}//class
