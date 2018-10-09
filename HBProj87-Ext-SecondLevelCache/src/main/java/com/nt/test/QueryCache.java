package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class QueryCache {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		List<Employee> list=null,list1=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Employee");
		list=query.list();
		list.forEach(emp->{
			System.out.println(emp.getEid()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary() );
		});
		System.out.println(".................");
		list1=query.list();
		list1.forEach(emp->{
			System.out.println(emp.getEid()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary() );
		});
		
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
