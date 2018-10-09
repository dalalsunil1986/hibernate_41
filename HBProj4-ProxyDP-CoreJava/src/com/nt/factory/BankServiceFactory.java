package com.nt.factory;

import com.nt.proxy.BankServiceProxy;
import com.nt.service.BankService;

public class BankServiceFactory {
	
	public static BankService getInstance(boolean RBIMonitoring){
		if(RBIMonitoring)
			return new BankServiceProxy();
		else
			return new BankService();
	}

}
