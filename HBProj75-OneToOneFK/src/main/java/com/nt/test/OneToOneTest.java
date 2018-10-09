package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//invoke methods
		try{
		  //dao.saveDataUsingPassport();
			//dao.loadDataUsingPassport();
			dao.deleteDataUsingPassport();
		  }
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
