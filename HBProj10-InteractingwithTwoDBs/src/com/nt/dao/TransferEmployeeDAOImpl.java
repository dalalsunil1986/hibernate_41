package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.MySqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferEmployeeDAOImpl implements TransferEmployeeDAO {

	@Override
	public boolean transferEmployee(int eno) {
		Session oraSes=null;
		Session mysqlSes=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		//get Sessions
		oraSes=OracleHibernateUtil.getSession();
		mysqlSes=MySqlHibernateUtil.getSession();
		//Load object from Oracle Db table
		emp=oraSes.get(Employee.class, eno);
		//save Object to mysql DB table
		try{
		 tx=mysqlSes.beginTransaction();
		  mysqlSes.save(emp);
		 flag=true;
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
			}
			else{
				tx.rollback();
			}
			OracleHibernateUtil.closeSession(oraSes);
			MySqlHibernateUtil.closeSession(mysqlSes);
		}//finally
		
		return flag;
	}//method
}//class
