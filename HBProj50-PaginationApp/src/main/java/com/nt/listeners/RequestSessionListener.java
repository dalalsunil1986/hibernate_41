package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.nt.utility.HibernateUtil;

@WebListener
public class RequestSessionListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed(-)");
		HttpServletRequest req=null;
		//get HttpServletRequest object
		req=(HttpServletRequest)sre.getServletRequest();
		if(req.getServletPath().equals("/controller")){
			System.out.println("requestDestroyed(-):controller");
			HibernateUtil.closeSession();
		}
		
	}

}
