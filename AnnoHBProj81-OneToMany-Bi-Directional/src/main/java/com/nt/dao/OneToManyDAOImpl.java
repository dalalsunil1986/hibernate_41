package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare parent object
		details=new UserDetails();
		details.setFirstName("amith sha");
		details.setAddress("gujju");
		//prepare child  objects
		ph1=new PhoneNumber();
		ph1.setPhone(59944999L);
		ph1.setNumberType("office");
		ph1.setProvider("airtel");
		
		ph2=new PhoneNumber();
		ph2.setPhone(77442455L);
		ph2.setNumberType("home");
		ph2.setProvider("vodafone");
		
		//add child objs to Collection
		childs=new HashSet();
		childs.add(ph1);
		childs.add(ph2);
		//add childs to Parent
		  details.setPhones(childs);
		 //assign parent to childs
		 ph1.setUser(details);
		 ph2.setUser(details);
		try{
		 tx=ses.beginTransaction();
		   //ses.save(details);
		 ses.persist(details);
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
	public void saveDataUsingPhoneNumber() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		PhoneNumber ph1=null,ph2=null;
		UserDetails user=null;
		Set<PhoneNumber> set=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare obj
		user=new UserDetails();
		user.setFirstName("jani");
		user.setAddress("hyd");
		
		ph1=new PhoneNumber();
		ph1.setPhone(9999999L);
		ph1.setProvider("airtel");
		ph1.setNumberType("office");
		
		ph2=new PhoneNumber();
		ph2.setPhone(88888888L);
		ph2.setProvider("vodafone");
		ph2.setNumberType("home");
		//add parent to childs
		ph1.setUser(user);
		ph2.setUser(user);
		//add childs to parent
		set=new HashSet<PhoneNumber>();
		set.add(ph1);set.add(ph2);
		user.setPhones(set);
		
		try{
	      tx=ses.beginTransaction();
            ses.save(ph1);
            ses.save(ph2);
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
			 System.out.println("Objects saved (child -parent)");	
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
	public void loadDataUsingPhoneNumber() {
		Session ses=null;
		Query query=null;
		List<PhoneNumber> list=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//prepare query
		query=ses.createQuery("from PhoneNumber");
		//execute query
		list=query.list();
		//process the List
		list.forEach(ph->{
            //Child obj
			System.out.println(ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			//get Associated parent obj
			UserDetails user=ph.getUser();
			System.out.println(user.getUserId()+" "+user.getFirstName()+" "+user.getAddress());
		});
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}
	
	
	@Override
	public void loadDataUsingUserDetails() {
		Session ses=null;
		Query query=null;
		List<UserDetails> list=null;
		try{
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from UserDetails");
		//execute Query
		list=query.list();
		//process the results
		list.forEach(user->{
			System.out.println("=>parent-->"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddress());
		  Set<PhoneNumber> childs=user.getPhones();
		  childs.forEach(ph->{
			  System.out.println("      :)->child-->"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
		  });
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
	
	@Override
	public void loadDataUsingUserDetailsAndJoins() {
		Session ses=null;
		Query query=null;
		List<UserDetails> list=null;
		try{
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select u from UserDetails u  inner join fetch u.phones");

		//execute Query
		list=query.list();
		//process the results
		list.forEach(user->{
			System.out.println("=>parent-->"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddress());
		  Set<PhoneNumber> childs=user.getPhones();
		  childs.forEach(ph->{
			  System.out.println("      :)->child-->"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
		  });
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
	
	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		Query query=null;
		List<UserDetails> list=null;
		Criteria criteria=null;
		try{
		//get SEssion
		ses=HibernateUtil.getSession();
		//create Criteria object
		criteria=ses.createCriteria(UserDetails.class);
		criteria.setFetchMode("phones",FetchMode.DEFAULT);
		list=criteria.list();
		list.forEach(details->{
			System.out.println("parent:"+details.getUserId()+" "+details.getFirstName()+" "+details.getAddress());
			Set<PhoneNumber> childs=details.getPhones();
			childs.forEach(ph->{
				System.out.println("child:"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			});
		});
		}
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

	@Override
	public void loadDataUsingPhoneNumberAndQBC() {
		Session ses=null;
		Query query=null;
		List<PhoneNumber> list=null;
		Criteria criteria=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//create Criteria
		criteria=ses.createCriteria(PhoneNumber.class);
		//execute query
		list=criteria.list();
		//process the List
		list.forEach(ph->{
            //Child obj
			System.out.println("child:"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			//get Associated parent obj
			UserDetails user=ph.getUser();
			System.out.println("parent:"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddress());
		});
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	
}//class
