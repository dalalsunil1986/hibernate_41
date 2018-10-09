package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
		Transaction tx=null;
		boolean flag=false;
		UserDetails details=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objs
		details=new UserDetails();
		details.setFirstName("raja");
		details.setAddress("hyd");
		//prpeare child objs
		ph1=new PhoneNumber();
		ph1.setPhone(9999999L);
		ph1.setProvider("airtel");
		ph1.setNumberType("office");
		
		ph2=new PhoneNumber();
		ph2.setPhone(888888L);
		ph2.setProvider("baba");
		ph2.setNumberType("home");
		childs=new HashSet();
		childs.add(ph1);
		childs.add(ph2);
		//set childs to parent
		details.setPhones(childs);
		
		try{
		 tx=ses.beginTransaction();
		   ses.save(details);
		 
		 flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadDataUsingUserDetails() {
		Session ses=null;
		List<UserDetails> list=null;
	try{
		//get Session 
		ses=HibernateUtil.getSession();
		list=ses.createQuery("from UserDetails").list();
		//process the collection
		list.forEach(user->{
			System.out.println("parent::"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddress());
			Set<PhoneNumber> childs=user.getPhones();
			//childs.size();
			childs.forEach(ph->{
				System.out.println("child::"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			});
		});
	}//try
	catch(HibernateException he){
		he.printStackTrace();
	}
	finally{
		HibernateUtil.closeSession(ses);
	}
		
	}//method
	
	@Override
	public void deleteOnePhoneNumberOfAUserDetails() {
		Session ses=null;
		UserDetails user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent obj
		user=ses.get(UserDetails.class,1);
		//get childs of a parent
		childs=user.getPhones();
		//Load child object
		ph=ses.get(PhoneNumber.class,9999999L);
		try{
		 tx=ses.beginTransaction();
		 
		 childs.remove(ph);
		 
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
				 System.out.println("one child from collection of childs removed");
			 }
			 else{
				 tx.rollback();
				 System.out.println("one child from collection of childs not removed"); 
			 }
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		List<UserDetails> list=null;
		Criteria criteria=null;
	try{
		//get Session 
		ses=HibernateUtil.getSession();
	    criteria=ses.createCriteria(UserDetails.class);
	    criteria.setFetchMode("phones",FetchMode.JOIN);
	    list=criteria.list();
		//process the collection
		list.forEach(user->{
			System.out.println("parent::"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddress());
			Set<PhoneNumber> childs=user.getPhones();
			//childs.size();
			childs.forEach(ph->{
				System.out.println("child::"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			});
		});
	}//try
	catch(HibernateException he){
		he.printStackTrace();
	}
	finally{
		HibernateUtil.closeSession(ses);
	}
		
		
	}//method
	
	
}//class
