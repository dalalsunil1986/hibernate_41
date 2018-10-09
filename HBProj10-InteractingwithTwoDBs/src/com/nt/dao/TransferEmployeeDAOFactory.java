package com.nt.dao;

public class TransferEmployeeDAOFactory {
	public static TransferEmployeeDAO getInstance(){
		return new TransferEmployeeDAOImpl();
	}

}
