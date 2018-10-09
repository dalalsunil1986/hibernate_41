package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Florist;
import com.nt.utility.HibernateUtil;

public class BasicLoadTest {

	public static void main(String[] args) {
		Session ses=null;
		Florist florist=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//Load Object
		try{
			florist=ses.get(Florist.class,9001);
			System.out.println(florist.getFlowerId()+" "+florist.getFlowerName()+" "+florist.getPrice()+" "+florist.getQtry()+" "+florist.getStatus());
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main

}//class
