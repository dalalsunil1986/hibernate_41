package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class PartialObjectUpdateTest {

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
		try{
		 tx=ses.beginTransaction();		
		//load object
		policy=ses.get(InsurancePolicy.class,1001);
		if(policy!=null){
		  
		    policy.setPremium(3044);
		    ses.update(policy);
		  flag=true;  
		  }
		else{
		  System.out.println("record not found");
		  flag=false;
		}
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Record found and updated");
			}
			else{
				tx.rollback();
				System.out.println("Record not found ");
			}
		 //close objs
			ses.close();
			factory.close();
		}//finally
	}//main
}//class
