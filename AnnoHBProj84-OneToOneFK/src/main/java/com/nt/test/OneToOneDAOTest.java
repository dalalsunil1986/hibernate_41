package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//invoke method
		dao.saveData();
		//close SEssion factory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
