package com.nt.proxy;

import com.nt.service.BankService;

public class BankServiceProxy extends BankService {
    private BankService service;
    
    public BankServiceProxy() {
    	//real object
		service=new BankService();
	}
    
    public String withdraw(int acno,float amt){
    	System.out.println("Proxy Logic withdraw(-,-)");
    	amt=amt- amt*0.01f;
    	return service.withdraw(acno, amt);
    	
    	
    }
}
