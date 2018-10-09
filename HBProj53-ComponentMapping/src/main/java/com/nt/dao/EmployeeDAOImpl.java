package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.domain.JobType;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void insertData() {
		Session ses=null;
		Transaction tx=null;
		JobType jt=null;
		Employee emp=null;
		int idVal=0;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		tx=ses.beginTransaction();
		try{
		 jt=new JobType();
		 jt.setDesg("CLERK");
		 jt.setCompany("HCL");
		 jt.setSalary(9000);
		 emp=new Employee();
		 emp.setPname("raja");
		 emp.setPjob(jt);
		 //save Object
		 idVal=(int) ses.save(emp);
		 System.out.println("Generated id value::"+idVal);
		 flag=true;
		}//try
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Object saved");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<Employee> list=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//create Query 
		query=ses.createQuery("from Employee where pjob.desg=:deg");
		query.setString("deg","PRESIDENT");
		list=query.list();
		//process the collecion
		list.forEach(emp->{
			System.out.println(emp.getPid()+" "+emp.getPname()+" "+emp.getPjob().getDesg()+" "+emp.getPjob().getCompany()+" "+emp.getPjob().getSalary());
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
