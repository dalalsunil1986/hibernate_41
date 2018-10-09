package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.ManufacturingCompany;
import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		ManufacturingCompany company=null;
		Product prod=null,prod1=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		company=new ManufacturingCompany();
		company.setCompName("HERO");
		company.setCompAddrs("Gurugram");
		
		prod=new Product();
		prod.setProdName("KARIZMA-ZMR");
		prod.setPrice(110000);
		
		prod1=new Product();
		prod1.setProdName("PassionPro");
		prod1.setPrice(60000);
		
		//set Parent to Chids
		prod.setCompany(company);
		prod1.setCompany(company);
		try{
		  tx=ses.beginTransaction();
		    ses.save(prod);
		    ses.save(prod1);
		  flag=true;
		}//try
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
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query=null;
		List<Product> list=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//create HQL Query
		query=ses.createQuery("from Product");
		//execute Query
		list=query.list();
		//process the result
		list.forEach(prod->{
			System.out.println("child:::"+prod.getProid()+" "+prod.getProdName()+" "+prod.getPrice());
			//get Associated Parent
			ManufacturingCompany company=prod.getCompany();
			//System.out.println("parent:::"+company.getCompId()+" "+company.getCompName()+" "+company.getCompAddrs());
		});
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
	}//method
	

}//class
