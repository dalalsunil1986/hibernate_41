package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		  childs.size();
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
	public void deleteOnePhoneNumberFromCollectionOfPhoneNumberBelogingToAUser() {
		Session ses=null;
		UserDetails user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//get Parent
		user=ses.get(UserDetails.class,1);
		//get All childs of a parent
		childs=user.getPhones();
		//Load child obj from DB s/w
		ph=ses.get(PhoneNumber.class,89994455L);
		try{
		 tx=ses.beginTransaction();	
		   childs.remove(ph);
		 flag=true;
		}//try
		catch(Exception e){
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("One child from collection of chids beloging to parent is deleted");
			}
			else{
				tx.rollback();
				System.out.println("One child from collection of chids beloging to parent not deleted");
			}
			//Close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
		Session ses=null;
		UserDetails user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//get Parent
		user=ses.get(UserDetails.class,2);
		//get All childs of a parent
		childs=user.getPhones();
		try{
			 tx=ses.beginTransaction();	
			   //childs.removeAll(childs);
			 childs.clear();
			 flag=true;
			}//try
			catch(Exception e){
				flag=false;
			}
			finally{
				if(flag){
					tx.commit();
					System.out.println("One child from collection of chids beloging to parent is deleted");
				}
				else{
					tx.rollback();
					System.out.println("One child from collection of chids beloging to parent not deleted");
				}
				//Close Session
				HibernateUtil.closeSession(ses);
			}//finally
	}//method
	
	@Override
	public void deleteUserAndItsChilds() {
		Session ses=null;
		UserDetails user=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent obj
		user=ses.get(UserDetails.class,1);
		try{
		 tx=ses.beginTransaction();
		  ses.delete(user);
         flag=true;		  
		}//try
		catch(HibernateException  he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("parent and its childs are deleted");
			}
			else{
				tx.rollback();
				System.out.println("parent and its childs are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void addNewPhoneNumberToAnExistingUser() {
		Session ses=null;
		UserDetails details=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load and an existing parent object
		details=ses.get(UserDetails.class,1);
		//get all child objects
		childs=details.getPhones();
		//create a new PhoneNumber
		ph=new PhoneNumber();
		ph.setPhone(9878787889L);
		ph.setNumberType("office");
		ph.setProvider("bsnrl");
		try{
		 tx=ses.beginTransaction();
		   childs.add(ph);
		 flag=true;
		}//try
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("New PhoneNumber is added");
			}
			else{
				tx.rollback();
				System.out.println("New PhoneNumber is not added");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void modifyPrivideOfPhoneNumberBelongingToAUser() {
		Session ses=null;
		UserDetails details=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load Parent
		details=ses.get(UserDetails.class,1);
		//get All childs
		childs=details.getPhones();
		//process the collection
		try{
		 tx=ses.beginTransaction();
		   childs.forEach(ph->{
			   if(ph.getProvider().equalsIgnoreCase("bsnrl")){
				   ph.setProvider("idea");
			   }
		   });
			
		 flag=true;
		}
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("The provide of PhoneNumber is changed");
			}
			else{
				tx.rollback();
				System.out.println("The Provide of PhoneNumber is not changed");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void transferPhoneNumberFromOneUserToAnotherUser() {
		Session ses=null;
		UserDetails user1=null,user2=null;
		Set<PhoneNumber> childs1=null,childs2=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load User1,user2
		user1=ses.get(UserDetails.class,1);
		user2=ses.get(UserDetails.class, 2);
		//get Childs of both user1,user2;
		childs1=user1.getPhones();
		childs2=user2.getPhones();
		//Load PhoneNumber that u want to transfer
		ph=ses.get(PhoneNumber.class,9878787889L);
		try{
		 tx=ses.beginTransaction();
		 //remove from user1
		 childs1.remove(ph);
		 ses.flush();
		  //add to user2
		 childs2.add(ph);
		 flag=true;	
		}//try
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("PhoneNumber transfered");
			}
			else{
				tx.rollback();
				System.out.println("PhoneNumber not transffered");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
/*	@Override  // Not Possible
	public void ModifyUserIdOfUser() {
		Session ses=null;
		UserDetails user1=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load User1,user2
		user1=ses.get(UserDetails.class,1);
		try{
		  tx=ses.beginTransaction();
		   user1.setUserId(10);
		   ses.flush();
		  flag=true;
		}//try
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("userId modified");
			}
			else{
				tx.rollback();
				System.out.println("UserId not modified");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
  */
}//class
