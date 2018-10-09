package com.nt.test;

import com.nt.dao.ProductSalesDAOFactory;
import com.nt.dao.ProductSalesInfoDAO;
import com.nt.utility.HibernateUtil;

public class CompositePKTest {

	public static void main(String[] args) {
		ProductSalesInfoDAO dao=null;
		//get DAO
		dao=ProductSalesDAOFactory.getInstance();
		//save object
		//dao.saveData();
		dao.loadData();
		
		//close objs
		HibernateUtil.closeSessionFactory();

	}//main
}//class
