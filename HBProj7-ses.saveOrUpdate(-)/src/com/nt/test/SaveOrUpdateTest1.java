package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class SaveOrUpdateTest1 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Product prod=null;
		//create Configuration object
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//buildSessionFactory
		factory=cfg.buildSessionFactory();
		//Create Session 
		ses=factory.openSession();
		//create Product class object
		prod=new Product();
		prod.setPid(0); prod.setPname("pr.table2");
		prod.setPrice(90000); prod.setQty(1);
		try{
		 tx=ses.beginTransaction();
		   ses.saveOrUpdate(prod);

		 flag=true;  
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Object saved/updated");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved/updated");
			}
			//close objs
			ses.close();
			factory.close();
		}//finally
		
	}//main
}//class
