package com.nt.test;

import com.nt.dao.AccountDAOFactory;
import com.nt.dao.AccountInfoDAO;
import com.nt.utility.HibernateUtil;

public class FilterTest {

	public static void main(String[] args) {
		AccountInfoDAO dao=null;
		//get DAO
		dao=AccountDAOFactory.getInstance();
		//invoke methods
		dao.getAllAccountDetailsAndBalnaceSum();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
