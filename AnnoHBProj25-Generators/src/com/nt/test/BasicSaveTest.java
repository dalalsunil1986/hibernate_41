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
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		Session ses=null;
		//get Session obj
		ses=HibernateUtil.getSession();
        
        //prepared Domain class object
        emp=new Employee();
        emp.setEid(1455);
        emp.setFirstName("Raja");
        emp.setLastName("chari"); emp.setEmail("22i4@g.com");
        emp.setSalary(7890.0f);
        
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
        	}
        	else{
        		tx.rollback();  //Internally calls con.rollback()
        		System.out.println("Object is not saved");
        	}
        	//close session
        	HibernateUtil.closeSession(ses);
        	//close sessionfactory
        	HibernateUtil.closeSessionFactory();
        }///finally
	}//main
}//class
