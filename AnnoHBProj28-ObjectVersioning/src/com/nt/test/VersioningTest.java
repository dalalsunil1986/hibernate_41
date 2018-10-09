package com.nt.test;

import com.nt.dao.MobileCustomerDAO;
import com.nt.dao.MobileCustomerDAOFactory;
import com.nt.utility.HibernateUtil;

public class VersioningTest {

	public static void main(String[] args) {
		MobileCustomerDAO dao=null;
		//get DAO
		dao=MobileCustomerDAOFactory.getInstance();
		//invoke method
		//dao.saveData();
		dao.updateData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
