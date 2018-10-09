package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class HQLInsertBadPraticeTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare and execute HQL insert Query
		query=ses.createQuery("insert into IplMatchInfo values(:val1,:val2,:val3,:val4,:val5)");
		//set param values
		query.setInteger("val1",2001);
		query.setString("val2","BvsB");
		query.setString("val3", "Bplace");
		query.setDate("val4",new Date());
		query.setString("val5","best wins");
		try{
		 tx=ses.beginTransaction();
		   query.executeUpdate();
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
				System.out.println("Record inserted");
			}
			else{
				tx.rollback();
				System.out.println("record not inserted");
			}
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
