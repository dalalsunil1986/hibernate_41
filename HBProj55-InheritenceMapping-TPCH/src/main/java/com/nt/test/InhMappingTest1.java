package com.nt.test;

import com.nt.dao.PersonDAO;
import com.nt.dao.PersonDAOFactory;
import com.nt.utility.HibernateUtil;

public class InhMappingTest1 {

	public static void main(String[] args) {
		PersonDAO dao=null;
		//get DAO
		dao=PersonDAOFactory.getInstance();
		 //save objects
		//dao.saveData();
		dao.loadData();
		
	  //close Session Factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
