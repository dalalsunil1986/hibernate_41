package com.nt.test;

import com.nt.factory.BankServiceFactory;
import com.nt.service.BankService;

public class ProxyDPTest {

	public static void main(String[] args) {
		BankService service=null;
		
		service=BankServiceFactory.getInstance(true);
		System.out.println(" with RBIMonitoring::"+service.withdraw(1001, 8000));
		System.out.println("...................");
		service=BankServiceFactory.getInstance(false);
		System.out.println(" with out RBIMonitoring::"+service.withdraw(1001, 8000));
		
		
		

	}

}
