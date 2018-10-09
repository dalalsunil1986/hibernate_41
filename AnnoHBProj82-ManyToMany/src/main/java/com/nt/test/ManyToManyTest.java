package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToManyTest {

	public static void main(String[] args) {
		ManyToManyDAO dao=null;
		//get DAO
		dao=ManyToManyDAOFactory.getInstance();
		//invoke methods
		dao.saveData();
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
