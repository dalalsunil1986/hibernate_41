package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class BasicSaveTest {

	public static void main(String[] args) {
		System.out.println("main(-) method....");
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;

		//get Session
		ses=HibernateUtil.getSession();
	       try{
	    	  Thread.sleep(30000);   
	       }
	       catch(Exception e){ }
	
        //prepared Domain class object
        emp=new Employee();
        emp.setEid(1045); emp.setFirstName("Raja");
        emp.setLastName("chari"); emp.setEmail("chari@gmail.com");
        emp.setSalary(78890.0f);
        System.out.println("----------------------");
        
        
        try{
        //Begin Tx
         tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
           //save object
           idVal=(Integer)ses.save(emp);
           System.out.println("Id value::"+idVal);
         flag=true;
        }
        catch(HibernateException he){
        	he.printStackTrace();
        	flag=false;
        }
        catch(Exception e){
        	e.printStackTrace();
        	flag=false;
        }
        finally{
        	if(flag==true){
        		tx.commit(); //Internally calls con.commit()
        	   System.out.println("Object is saved");
        	   try{
        	   Thread.sleep(20000);
        	   }
        	   catch(Exception e){ e.printStackTrace(); }
        	}
        	else{
        		//tx.rollback();  //Internally calls con.rollback()
        		System.out.println("Object is not saved");
           }
         HibernateUtil.closeSession(ses);
         HibernateUtil.closeSessionFactory();
        }///finally
	}//main
}//class
