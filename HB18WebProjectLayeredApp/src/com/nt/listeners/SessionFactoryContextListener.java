package com.nt.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class SessionFactoryContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce){
		System.out.println("ContextInitialized");
		try{
	   Class.forName("com.nt.utility.HibernateUtil");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	   System.out.println("ContextDestorye(-)");
	   HibernateUtil.closeSessionFactory();
	}
	
}
