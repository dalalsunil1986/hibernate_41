package com.nt.test;

import org.hibernate.HibernateException;

import com.nt.dao.EmployeeLOBDAO;
import com.nt.dao.EmployeeLOBDAOFactory;
import com.nt.utility.HibernateUtil;

public class LOBTestClient {

	public static void main(String[] args) {
		EmployeeLOBDAO dao=null;
		//get DAO
		dao=EmployeeLOBDAOFactory.getInstance();
		try{
		//save Data
		//dao.saveData();
		//load data
			dao.loadData();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
