package com.nt.dao;

public class MobileCustomerDAOFactory {
   public static  MobileCustomerDAO  getInstance(){
	   return new MobileCustomerDAOImpl();
	   
   }
}
