package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Employee emp=null,emp1=null,emp2=null,emp3=null;
		//Get Session
		ses=HibernateUtil.getSession();
		try{
		//Load object
		emp=ses.get(Employee.class, 1001); //Loads from DB and keeps in L1 cache
		 System.out.println(emp.getEid()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary());
		 
		 emp2=ses.get(Employee.class, 1045); //Loads from DB and keeps in L1 cache
		 System.out.println(emp2.getEid()+" "+emp2.getFirstName()+" "+emp2.getLastName()+" "+emp2.getSalary());
		
		 
		 //ses.evict(emp);
		 ses.clear();
		 System.out.println("..................");
		 
		 emp1=ses.get(Employee.class,1001);//Loads from L1 cache
		 System.out.println(emp1.getEid()+" "+emp1.getFirstName()+" "+emp1.getLastName()+" "+emp1.getSalary());
		 
		 emp3=ses.get(Employee.class, 1045); //Loads from DB and keeps in L1 cache
		 System.out.println(emp3.getEid()+" "+emp3.getFirstName()+" "+emp3.getLastName()+" "+emp3.getSalary());
		
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
