package com.nt.dao;

public class HQLInsertDAOFactory {
	public static  HQLInsertDAO getInstance(){
		return new HQLInsertDAOImpl();
	}

}
