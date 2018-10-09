package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class SecondLevelCacheTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Employee emp1=null,emp2=null,emp3=null,emp4=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//Load object
		emp1=ses.get(Employee.class,101);  //gets Object from DB s/w and keeps in L2, L1 caches
		System.out.println(emp1.getEid()+" "+emp1.getFirstName()+" "+emp1.getLastName()+" "+emp1.getSalary());
	
		emp2=ses.get(Employee.class, 101); //gets Object L1 cache
		System.out.println(emp2.getEid()+" "+emp2.getFirstName()+" "+emp2.getLastName()+" "+emp2.getSalary());
		ses.evict(Employee.class);//Removes obj from L1 cache
		
		emp3=ses.get(Employee.class, 101); //gets Object L2 cache and keeps L1 cache
		System.out.println(emp3.getEid()+" "+emp3.getFirstName()+" "+emp3.getLastName()+" "+emp3.getSalary());
		ses.clear(); //Removes obj from L1 cache
		try{
		Thread.sleep(11000); //Removes obj even from L2 cache
		}
		catch(InterruptedException ire){
			ire.printStackTrace();
		}
		
		emp4=ses.get(Employee.class,101); //get Obj from DB s/w and keeps in L2 and L1 caches
		System.out.println(emp4.getEid()+" "+emp4.getFirstName()+" "+emp4.getLastName()+" "+emp4.getSalary());
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
