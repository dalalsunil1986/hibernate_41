package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	
	static{
		Configuration cfg=null;
		System.out.println("static block of HibernateUtil");
	 try{	
		//create Configuration obj
		 cfg=new Configuration();
		 cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory object
		 factory=cfg.buildSessionFactory();
	 }//try
	 catch(HibernateException he){
		 he.printStackTrace();
	 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	}//static
	
	public static Session getSession(){
		Session ses=null;
		if(threadLocal.get()==null){
			ses=factory.openSession();
			threadLocal.set(ses);
		}
		else{
			ses=threadLocal.get();
		}
		return ses;
	}//getSession()
	
	public  static  void closeSession(){
		Session ses=null;
		ses=threadLocal.get();
		if(ses!=null){
			ses.close();
			threadLocal.remove();
		}
	}//closeSession()
	
	public  static  void  closeSessionFactory(){
		if(factory!=null)
			factory.close();
	}//closeSEssionFactory()
	
}//class
