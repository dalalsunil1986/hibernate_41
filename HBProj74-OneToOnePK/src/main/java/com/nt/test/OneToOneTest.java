package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		try{
		  //dao.saveDataUsingStudent();
		//dao.saveDataUsingLibraryMembership();
			//dao.loadDataUsingStudent();
			//dao.loadDataUsingLibraryMembership();
			//dao.deleteDataUsingStudent();
			dao.deleteOnlyMemershipOfStudent();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		HibernateUtil.closeSessionFactory();

	}//main
}//class
