package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.nt.domain.Customer;
import com.nt.domain.Employee;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person per=null;
		Employee emp=null;
		Customer cust=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		per=new Person();
		per.setPname("raja");
		per.setCompany("HCL");
		
		emp=new Employee();
		emp.setPname("ramesh");
		emp.setCompany("Wipro");
		emp.setDesg("CLERK");
		emp.setSalary(9000);
		
		cust=new Customer();
		cust.setPname("rakesh");
		cust.setCompany("InfoSys");
		cust.setAddress("HYD");
		cust.setBillAmt(8000);
		
		try{
		  tx=ses.beginTransaction();
		    ses.save(per);
		    ses.save(emp);
		    ses.save(cust);
		  flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		 		
			HibernateUtil.closeSession(ses);
		}
	}//method

	@Override
	public void loadData() {
		Session ses=null;
		List<Person> list1=null;
		List<Employee> list2=null;
		List<Customer> list3=null;
		Query query1=null,query2=null,query3=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//create Queries
		System.out.println("Using Person....");
		query1=ses.createQuery("from Person");
		list1=query1.list();
		list1.forEach(per->{
			System.out.println(per.getPid()+" "+per.getPname()+" "+per.getCompany());
		});
		System.out.println("----------------------");
		System.out.println("Using Employee....");
		query2=ses.createQuery("from Employee");
		list2=query2.list();
		list2.forEach(emp->{
			System.out.println(emp.getPid()+" "+emp.getPname()+" "+emp.getCompany()+" "+emp.getDesg()+" "+emp.getSalary());
		});
		System.out.println("----------------------");
		System.out.println("Using Customer....");
		query3=ses.createQuery("from Customer");
		list3=query3.list();
		list3.forEach(cust->{
			System.out.println(cust.getPid()+" "+cust.getPname()+" "+cust.getCompany()+" "+cust.getAddress()+" "+cust.getBillAmt());
		});
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
	}//method
}//class
