package com.nt.dao;

public class AccountDAOFactory {
	public static AccountInfoDAO getInstance(){
		return new AccountInfoDAOImpl();
	}

}
