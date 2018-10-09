package com.nt.test;

import com.nt.dao.HQLInsertDAO;
import com.nt.dao.HQLInsertDAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertBestPraticeTest {

	public static void main(String[] args) {
		HQLInsertDAO dao=null;
		int count=0;
		//get DAO
		dao=HQLInsertDAOFactory.getInstance();
		//invoke method
		count=dao.transferEmployeesToNGOMembers(5000);
		System.out.println("no.of records copied are::"+count);
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}
}
