package com.nt.test;

import org.hibernate.HibernateException;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
		try{
		  //dao.loadDataUsingUserDetailsAndHQLJoins();
			dao.loadDataUsingPhoneNumberAndHQLJoins();
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
