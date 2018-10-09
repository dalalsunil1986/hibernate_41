package com.nt.dao;

public class BSEStockDAOFactory {
	public static BSEStockDAO getInstance(){
		return  new BSEStockDAOImpl();
	}

}
