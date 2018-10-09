package com.nt.test;

import com.nt.dao.AuthenticateDAO;
import com.nt.dao.AuthenticationDAOFactory;
import com.nt.utility.HibernateUtil;

public class ProcedureTest {

	public static void main(String[] args) {
		AuthenticateDAO dao=null;
		String result=null;
		//get DAO
		dao=AuthenticationDAOFactory.getInstance();
		//use DAO
		result=dao.authenticate("raja","rani");
		System.out.println("result is::"+result);
		//close objs
		HibernateUtil.closeSessionFactory();
	}
}
