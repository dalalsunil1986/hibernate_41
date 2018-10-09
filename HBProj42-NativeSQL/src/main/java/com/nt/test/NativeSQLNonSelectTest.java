package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class NativeSQLNonSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		SQLQuery query=null;
		int count=0;
		// Get session
		ses=HibernateUtil.getSession();
		//prpeare SQL Query
		query=ses.createSQLQuery("INSERT INTO VOTERINFO VALUES(:val1,:val2,:val3,:val4,:val5)");
		//set values to query params
		query.setInteger("val1",2001);
		query.setString("val2","karan");
		query.setDate("val3",new Date());
		query.setString("val4","sanathnagar");
		query.setString("val5","Secunderabad");
		try{
		  tx=ses.beginTransaction();
		   count=query.executeUpdate();
		  flag=true;
		}
		catch(HibernateException he){
			flag=false;
		}
		catch(Exception e){
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("record inserted");
			}
			else{
				tx.rollback();
				System.out.println("record not inserted");
			}
		 //close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
