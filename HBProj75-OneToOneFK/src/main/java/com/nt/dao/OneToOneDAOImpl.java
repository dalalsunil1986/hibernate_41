package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Passport;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveDataUsingPassport() {
		Session ses=null;
		Person person1=null;
		Person person2=null;
		Passport  pspt=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		person1=new Person();
		person1.setPname("raja");
		person1.setAddress("hyd");
		
		person2=new Person();
		person2.setPname("ramesh");
		person2.setAddress("vizag");
		
		pspt=new Passport();
		pspt.setCountry("India");
		pspt.setPsptType("reqular");
		pspt.setPsptHolder(person1);
		try{
		 tx=ses.beginTransaction();
		   ses.save(pspt);
		   ses.save(person2);
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
				System.out.println("objects are saved");
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
	public void loadDataUsingPassport() {
		Session ses=null;
		List<Passport> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		//prepare Query
		query=ses.createQuery("from Passport");
		//execute Query
		list=query.list();
		//process the list
		list.forEach(pspt->{
			Person per=null;
			System.out.println(pspt.getPsptNo()+" "+pspt.getCountry()+" "+pspt.getPsptType());
			per=pspt.getPsptHolder();
			System.out.println(per.getPid()+" "+per.getPname()+" "+per.getAddress());
		});
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
		
		//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void deleteDataUsingPassport() {
		Session ses=null;
		Passport pspt=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load child obj
		pspt=ses.get(Passport.class,100001);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(pspt);
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
				System.out.println("child and its parent deleted");
			}
			else{
				tx.rollback();
				System.out.println("child and its parent not deleted");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally

	}//method
	
}//class
