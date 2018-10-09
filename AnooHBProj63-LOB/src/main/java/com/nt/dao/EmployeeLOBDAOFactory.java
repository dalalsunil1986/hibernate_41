package com.nt.dao;

public class EmployeeLOBDAOFactory {
	public static EmployeeLOBDAO getInstance(){
		return new EmployeeLOBDAOImpl();
		
	}

}
