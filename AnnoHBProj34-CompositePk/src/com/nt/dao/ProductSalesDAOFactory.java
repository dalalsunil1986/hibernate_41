package com.nt.dao;

public class ProductSalesDAOFactory {
    public static ProductSalesInfoDAO getInstance(){
    	return new ProductSalesDAOImpl();
    }
}
