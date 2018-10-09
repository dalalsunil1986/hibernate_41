package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Department;
import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Department dept=null;
		EmpDetails emp1=null,emp2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		dept=new Department();
		dept.setDeptName("IT");
		dept.setDeptLoc("HYD");
		
		emp1=new EmpDetails();
		emp1.setEmpName("raja");
		emp1.setEmpDesg("Developer");
		
		emp2=new EmpDetails();
		emp2.setEmpName("rani");
		emp2.setEmpDesg("Developer");
		
		//set parent to childs
		emp1.setDept(dept);
		emp2.setDept(dept);
		try{
		 tx=ses.beginTransaction();
		 
		  ses.save(emp1);
		  ses.save(emp2);
		 flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved..");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		List<EmpDetails>  list=null;
		Query query=null;
		try{
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare HQL Query and execute it
		query=ses.createQuery("from EmpDetails");
		list=query.list();
		list.forEach(emp->{
			System.out.println("child--->"+emp.getEmpNo()+" "+emp.getEmpName()+" "+emp.getEmpDesg());
			Department dept=emp.getDept();
			System.out.println("parent-->"+dept.getDeptNo()+" "+dept.getDeptName()+" "+dept.getDeptLoc()+" "+dept.getClass());
		});
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void deleteOneEmployeeOfADepartment() {
		/*  //Bad code becoz we need to place cascade="none" in the middle of the execution
		 *    which is practically imposible
		  Session ses=null;
		EmpDetails emp=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load child obj
		emp=ses.get(EmpDetails.class,4);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(emp);
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
			if(flag){
				tx.commit();
				System.out.println("One child is deleted");
			}
			else{
				tx.rollback();
				System.out.println("One child is not deleted");
			}
			
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
*/	
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare  Query
		query=ses.createQuery("delete from EmpDetails where empno=:no");
		//set values to query params
		query.setInteger("no",6);
		try{
	      tx=ses.beginTransaction();
	        int result=query.executeUpdate();
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
			if(flag){
				tx.commit();
				System.out.println("Only child is deleted");
			}
			else{
				tx.rollback();
				System.out.println("child not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void deleteAllEmployeesAndItsDepartment() {
		Session ses=HibernateUtil.getSession();
		List<EmpDetails> list=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		//load all childs
		query=ses.createQuery("from EmpDetails");
		list=query.list();
		try{
		 tx=ses.beginTransaction();
		  list.forEach(emp->{
			  ses.delete(emp);
		  });
		 flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("childs and its parent are deleted");
			}
			else{
				tx.rollback();
				System.out.println("childs and its parent are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void deleteAllEmployeesOfADepartment() {
		Session ses=HibernateUtil.getSession();
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		int result=0;
		//prepare and execute Query
		query=ses.createQuery("delete from EmpDetails where dept.deptNo=:dno");
		//set query param value
		query.setInteger("dno",1);
		try{
		  tx=ses.beginTransaction();
		   result=query.executeUpdate();
		  flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("all childs of a Parent are deleted");
			}
			else{
				tx.rollback();
				System.out.println("all childs of a parent  are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void AddNewEmployeeToExitingDepartment() {
		Session ses=HibernateUtil.getSession();
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		Department dept=null;
		EmpDetails emp=null;
	    //Load existing parent
		dept=ses.get(Department.class,1);
		//create new child
		emp=new EmpDetails();
		emp.setEmpName("jani");
		emp.setEmpDesg("CLERK");
		//add existing parent to child
		emp.setDept(dept);
		try{
		 tx=ses.beginTransaction();
		   ses.save(emp);
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
			if(flag){
				tx.commit();
				System.out.println("new child is added having existing parent");
			}
			else{
				tx.rollback();
				System.out.println("new child is not added having existing parent");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
}//class
