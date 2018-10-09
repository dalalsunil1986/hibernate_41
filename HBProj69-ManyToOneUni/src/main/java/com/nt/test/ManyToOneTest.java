package com.nt.test;

import com.nt.dao.ManyToOneDAO;
import com.nt.dao.ManyToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class ManyToOneTest {

	public static void main(String[] args) {
		ManyToOneDAO dao=null;
		//get DAO
		dao=ManyToOneDAOFactory.getInstance();
		//use DAO
		try{
			//dao.saveData();
			//dao.loadData();
			//dao.deleteOneEmployeeOfADepartment();
			//dao.deleteAllEmployeesAndItsDepartment();
			//dao.deleteAllEmployeesOfADepartment();
			dao.AddNewEmployeeToExitingDepartment();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close objs
		HibernateUtil.closeSessionFactory();
	}//main
}//class
