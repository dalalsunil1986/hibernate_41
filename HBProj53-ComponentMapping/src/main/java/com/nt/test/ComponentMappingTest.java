package com.nt.test;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
		EmployeeDAO dao=null;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//save Object
		//dao.insertData();
		dao.loadData();
		//close Session
		HibernateUtil.closeSessionFactory();
	}

}
