package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.UserDetails;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingUserDetails() {
		Session ses=null;
		UserDetails details=null;
		PhoneNumber ph1=null,ph2=null;
		List<PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare parent object
		details=new UserDetails();
		details.setFirstName("ranga");
		details.setAddress("hyd");
		//prepare child  objects
		ph1=new PhoneNumber();
		ph1.setPhone(39944999L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");
		
		ph2=new PhoneNumber();
		ph2.setPhone(75442455L);
		ph2.setNumberType("home");
		ph2.setProvider("vodafone");
		
		//add child objs to Collection
		childs=new ArrayList();
		childs.add(ph1);
		childs.add(ph2);
		//add childs to Parent
		  details.setPhones(childs);
		try{
		 tx=ses.beginTransaction();
		   //ses.save(details);
		 ses.save(details);
		 flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
			 System.out.println("Objects saved (parent-child)");	
			}
			else{
				tx.rollback();
				System.out.println("Objects not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void deleteOnePhoneNumberFromCollectionOfPhoneNumbersBelongingToAUser() {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		UserDetails user=null;
		List<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load Parent
		user=ses.get(UserDetails.class, 1);
		//get childs of a parent
		childs=user.getPhones();
		try{
		 tx=ses.beginTransaction();	
			childs.remove(0);
		 flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
			 System.out.println("One child from Collection of childs is removed");	
			}
			else{
				tx.rollback();
				System.out.println("One child from collection of childs is not removed");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
 }//class
