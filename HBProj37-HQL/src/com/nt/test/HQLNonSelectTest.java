package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class HQLNonSelectTest {

	public static void main(String[] args) {
		Session ses = null;
		Query query = null;
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		// Get Session object
		ses = HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("update IplMatchInfo set location=:newLoc where location=:oldLoc");
		//set values
		query.setString("newLoc","pune");
		query.setString("oldLoc","chenai");
		try{
		 //begin Transaction
			tx=ses.beginTransaction();
			 count=query.executeUpdate();
			flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			 e.printStackTrace();
			 flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("no.of reords that effected::"+count);
			}
			else{
				tx.rollback();
				System.out.println("no record found");
			}
			// close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}// main
}// class
