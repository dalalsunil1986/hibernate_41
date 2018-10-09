package com.nt.test;

import com.nt.dao.BSEStockDAO;
import com.nt.dao.BSEStockDAOFactory;
import com.nt.utility.HibernateUtil;

public class ObjectTimeStampingAndVersioningTest {

	public static void main(String[] args) {
		BSEStockDAO dao=null;
		// Get DAO
		dao=BSEStockDAOFactory.getInstance();
		//save object
		//dao.saveData();
		dao.updateData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
