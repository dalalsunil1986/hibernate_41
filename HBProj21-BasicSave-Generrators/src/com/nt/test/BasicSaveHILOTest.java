package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class BasicSaveHILOTest {

	public static void main(String[] args) {
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0,idVal1=0;
		Session ses=null;
		//get Session obj
		ses=HibernateUtil.getSession();
        
        //prepared Domain class object
        
        
        try{
         	tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
           //save object
          for(int i=1;i<=10;++i){
        	  emp=new Employee();
              emp.setFirstName("Raja"+i);
              emp.setLastName("chari"+i); emp.setEmail("221i4@g.com"+i);
              emp.setSalary(7890.0f);
           idVal=(Integer)ses.save(emp);
           System.out.println("Id value::"+idVal);
           flag=true;
          }
    
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
        		tx.commit();
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
