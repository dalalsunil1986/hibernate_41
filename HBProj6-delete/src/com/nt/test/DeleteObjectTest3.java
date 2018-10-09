package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class DeleteObjectTest3 {
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
	//get Object
	policy=ses.get(InsurancePolicy.class,7889);
	if(policy!=null){
	try{
	   ses.delete(policy);
	   ses.flush();
	   System.out.println("Object/record deleted");
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
	}//finally
	}//if
   }//main  	
}//class
