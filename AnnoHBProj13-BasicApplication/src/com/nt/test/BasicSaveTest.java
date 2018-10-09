package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Florist;
import com.nt.utility.HibernateUtil;

public class BasicSaveTest {

	public static void main(String[] args) {
		Session ses=null;
		Florist florist=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//prepare Object
		florist=new Florist();
		florist.setFlowerId(9020);
		florist.setFlowerName("sunflower");
		florist.setQtry(1);
		florist.setPrice(100);
		florist.setStatus("rare");
		//save Object
		try{
	      tx=ses.beginTransaction();
	       ses.save(florist);
	      flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Object saved");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved");
			}
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//main
	}//class

}
