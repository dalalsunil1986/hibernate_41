package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		Map<String,PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objs
		details=new UserDetails();
		details.setFirstName("karan");
		details.setAddress("vizag");
		//prpeare child objs
		ph1=new PhoneNumber();
		ph1.setPhone(9999493L);
		ph1.setProvider("jio");
		ph1.setNumberType("office");
		
		ph2=new PhoneNumber();
		ph2.setPhone(8883348L);
		ph2.setProvider("baba2");
		ph2.setNumberType("home");
		childs=new HashMap();
		childs.put("calls",ph1);
		childs.put("chats",ph2);
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
	
		
}//class
