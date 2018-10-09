package com.nt.test;

import com.nt.dao.BankDAO;
import com.nt.dao.BankDAOFactory;
import com.nt.utility.HibernateUtil;

public class LocalTransationTest {
	public static void main(String[] args) {
		BankDAO dao=null;
		boolean status=false;
		//get DAO
		dao=BankDAOFactory.getInstance();
		//invoke method
		status=dao.transferMoney(1006, 1002, 2000);
		if(status){
			System.out.println("Money Transfered--Tx committed");
		}
		else{
			System.out.println("Money not Transffered-Tx rollbacked");
		}
		
		HibernateUtil.closeSessionFactory();
		
	}

}
