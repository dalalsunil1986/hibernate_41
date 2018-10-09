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
	public void loadDataUsingUserDetailsAndHQLJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//prepare joings query parent to child  
		query=ses.createQuery("select u.userId,u.firstName,ph.phone,ph.numberType from UserDetails u full join u.phones ph");
		//execute query
		list=query.list();
		//process the List
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
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
	public void loadDataUsingPhoneNumberAndHQLJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		try{
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select ph.phone,ph.numberType,u.userId,u.firstName from PhoneNumber ph full join ph.user u");
		//execute Query
		list=query.list();
		
		//process the results
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
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
