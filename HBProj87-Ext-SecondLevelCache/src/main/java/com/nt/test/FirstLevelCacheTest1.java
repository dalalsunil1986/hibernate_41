package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Employee emp=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//Load object
		emp=ses.get(Employee.class, 1001);
		try{
		 tx=ses.beginTransaction();	
			emp.setLastName("rao-->reddy");
			emp.setSalary(70000.0f);
		 flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Tx committed");
			}
			else{
				tx.rollback();
				System.out.println("Tx Rolledback");
			}
		}

	}

}
