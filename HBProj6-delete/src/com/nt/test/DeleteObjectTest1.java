package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class DeleteObjectTest1 {
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
	policy=ses.get(InsurancePolicy.class,1002);
	if(policy!=null){
	try{
	 tx=ses.beginTransaction();
	   ses.delete(policy);
	   flag=true;
	}
	catch(HibernateException he){
		flag=false;
		he.printStackTrace();
	}
	catch(Exception e){
		flag=false;
		e.printStackTrace();
	}
	finally{
	     if(flag){
	    	 tx.commit();
	    	 System.out.println("Object /record deleted");
	     }
	     else{
	    	 tx.rollback();
	    	 System.out.println("Object/record not found");
	     }
		//close objs
		ses.close();
		factory.close();
	}//finally
	}//if
   }//main  	
}//class
