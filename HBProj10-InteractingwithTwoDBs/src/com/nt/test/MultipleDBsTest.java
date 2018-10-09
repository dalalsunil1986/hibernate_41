package com.nt.test;

import org.hibernate.HibernateException;

import com.nt.dao.TransferEmployeeDAO;
import com.nt.dao.TransferEmployeeDAOFactory;
import com.nt.utility.MySqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class MultipleDBsTest {

	public static void main(String[] args) {
		TransferEmployeeDAO dao=null;
	  // get DAO
		dao=TransferEmployeeDAOFactory.getInstance();
		//invoke the method
		try{
			System.out.println("Employee Transffered?"+dao.transferEmployee(1001));
		}
		catch(HibernateException he){
			System.out.println("Internal problem"+he.getMessage());
		}
		catch(Exception e){
			System.out.println("Internal problem"+e.getMessage());
		}
		//close session factories
		OracleHibernateUtil.closeSessionFactory();
		MySqlHibernateUtil.closeSessionFactory();
	}//main
}//class
