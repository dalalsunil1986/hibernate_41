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
		//dao.saveDataUsingProgrammer();
		//dao.saveDataUsingProject();
		//dao.loadDataUsingProgrammer();
		//dao.loadDataUsingProject();
		//dao.relieveProgramerFromAProject();
		//dao.AssignExistingProgrammerToExistingProject();
		dao.transferProject();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
