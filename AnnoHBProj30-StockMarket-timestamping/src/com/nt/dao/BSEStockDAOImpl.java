package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.BSEStock;
import com.nt.utility.HibernateUtil;

public class BSEStockDAOImpl implements BSEStockDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		BSEStock stock=null;
		int idVal=0;
		//get Session
       ses=HibernateUtil.getSession();
       //prepare Object
       stock=new BSEStock();
       stock.setStockName("icici");
       stock.setPrice(500);
       
       try{
    	 tx=ses.beginTransaction();
    	  idVal=(int)ses.save(stock);
    	 flag=true;
       }
       catch(HibernateException he){
    	   flag=false;
    	   he.printStackTrace();
       }  
       catch(Exception e){
    	   flag=false;
    	   e.printStackTrace();
       }
       finally{
    	   if(flag){
    		   tx.commit();
    		   System.out.println("object saved with id val"+idVal);
    	   }
    	   else{
    		   tx.rollback();
    		   System.out.println("object is not saved");
    	   }
    	   //close Session
    	   HibernateUtil.closeSession(ses);
       }//finally
	}//method

	@Override
	public void updateData() {
		Session ses=null;
		BSEStock stock=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
       ses=HibernateUtil.getSession();
       //load object
       stock=ses.get(BSEStock.class,20);
       try{
    	   tx=ses.beginTransaction();
    	    stock.setPrice(602);
    	   flag=true;
       }
       catch(HibernateException he){
    	   he.printStackTrace();
    	   flag=false;
       }
       catch(Exception e){
    	   flag=false;
    	   e.printStackTrace();
       }
       finally{
    	   if(flag){
    		   tx.commit();
    		   System.out.println("Object updated at-->"+stock.getLastUpdated());
    	   }
    	   else{
    		   tx.rollback();
    		   System.out.println("object is not updated");
    	   }
    	   //close Session
    	   HibernateUtil.closeSession(ses);
       }//finally
	}//method
}//class
