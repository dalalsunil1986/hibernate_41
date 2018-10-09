package com.nt.utility;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.BootstrapServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static{
	 try{	
	  Configuration cfg=null;
	  ServiceRegistryBuilder builder=null;
	  ServiceRegistry registry=null;
	  //BootStrap hibernate
	  cfg=new Configuration();
	  cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
	  //create ServiceRegistryBuilder
	  builder=new ServiceRegistryBuilder();
	  registry=builder.applySettings(cfg.getProperties()).buildServiceRegistry();
	  //create SessionFactory object
	  factory=cfg.buildSessionFactory(registry);
	 }
	 catch(HibernateException he){
		 he.printStackTrace();
	 }
	}
	
	public static Session getSession(){
		Session ses=null;
		//create Session
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static void closeSession(Session ses){
		if(ses!=null)
			ses.close();
	}
	
	public static  void closeSessionFactory(){
		if(factory!=null)
			factory.close();
	}

}
