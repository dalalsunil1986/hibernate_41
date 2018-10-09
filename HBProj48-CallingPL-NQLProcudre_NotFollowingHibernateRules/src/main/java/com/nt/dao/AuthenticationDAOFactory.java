package com.nt.dao;

public class AuthenticationDAOFactory {
	public static AuthenticateDAO getInstance(){
		//return new AuthenticateDAOImpl();
		//return new AuthenticateDAOImpl1();
		return new AuthenticateDAOImpl2();
	}

}
