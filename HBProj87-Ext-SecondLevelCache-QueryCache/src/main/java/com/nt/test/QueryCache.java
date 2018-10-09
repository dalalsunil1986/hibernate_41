package com.nt.test;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class QueryCache {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		List<Employee> list=null,list1=null;
		
		//Get Session
		Configuration cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		
		//prepare Query
		query=ses.createQuery("from Employee");
		query.setCacheable(true);
		query.setCacheRegion("region1");
		list=query.list();
		list.forEach(emp->{
			System.out.println(emp.getEid()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary() );
		});
		System.out.println(".................");
		list1=query.list();
		list1.forEach(emp->{
			System.out.println(emp.getEid()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary() );
		});
		
		Cache cache=factory.getCache();
		cache.evictQueryRegion("region1");
		list1=query.list();
		list1.forEach(emp->{
			System.out.println(emp.getEid()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary() );
		});
		
	
		
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
