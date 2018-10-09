package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.MobileCustomer;
import com.nt.utility.HibernateUtil;

public class MobileCustomerDAOImpl implements MobileCustomerDAO {
    
	@Override
	public void saveData() {
		Session ses=null;
		MobileCustomer customer=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
	   //create Doamin class obj
		customer=new MobileCustomer();
		customer.setCustName("Rajesh");
		customer.setPhoneNumber(99999999L);
		customer.setCallerTune("Dil Jale");
		try{
		  tx=ses.beginTransaction();
		  idVal=(int)ses.save(customer);
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
				System.out.println("Object is saved with idval :::"+idVal);
			}
			else{
				tx.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void updateData() {
		Session ses=null;
		MobileCustomer customer=null;
		Transaction tx=null;
		boolean flag=false;
		//get Sesssion
		ses=HibernateUtil.getSession();
		//Load Object
		customer=ses.get(MobileCustomer.class,100);
		try{
		 tx=ses.beginTransaction();
		  customer.setCallerTune("Dil pukare");
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
				System.out.println("Object is updated for "+customer.getVer()+" no.of times");
			}
			else{
				tx.rollback();
				System.out.println("Object is not updated");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
}
