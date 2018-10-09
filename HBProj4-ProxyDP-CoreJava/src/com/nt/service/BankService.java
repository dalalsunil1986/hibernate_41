package com.nt.service;

public class BankService {
	public String withdraw(int acno,float amt){
		System.out.println("BankService:withdraw(-,-) (real logic)");
		return "withdrawing amount "+amt +" from account number:"+acno;
	}

}
