package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class HQLInsertDAOImpl implements HQLInsertDAO {
 private static final String HQL_INSERT_QUERY="INSERT INTO NGOMember(mid,firstName,lastName) select e.eid,e.firstName,e.lastName from Employee e where e.salary>=:minSal";
	@Override
	public int transferEmployeesToNGOMembers(int minSalary) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		int count=0;
    //get Session
		ses=HibernateUtil.getSession();
		//prpeare and execute HQL Insert Query
		query=ses.createQuery(HQL_INSERT_QUERY);
		query.setInteger("minSal",minSalary);
		try{
		  tx=ses.beginTransaction();
		  count=query.executeUpdate();
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
		 }
		 else{
			 tx.rollback();
		 }
		 HibernateUtil.closeSession(ses);
		}
		
		return count;
	}//method
}//class
