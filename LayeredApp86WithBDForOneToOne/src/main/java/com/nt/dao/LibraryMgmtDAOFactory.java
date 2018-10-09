package com.nt.dao;

public class LibraryMgmtDAOFactory {
	public static LibraryMgmtDAO getInstance(){
		return new  LibraryMgmtDAOImpl();
	}

}
