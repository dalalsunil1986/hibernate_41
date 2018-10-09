package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.ProductSalesInfo;
import com.nt.utility.HibernateUtil;

public class ProductSalesDAOImpl implements ProductSalesInfoDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ProductSalesInfo info=null,idVal=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//Domain class obj
		info=new ProductSalesInfo();
		info.setProdId(101);
		info.setProdName("baba oil");
		info.setCustId(2345);
		info.setCustName("rani");
		info.setPrice(80);
		try{
		  tx=ses.beginTransaction();
		  idVal=(ProductSalesInfo)ses.save(info);
		  System.out.println("Composite IdVal::"+idVal.getCustId()+" "+idVal.getProdId());
		  flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Object saved");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved");
			}
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void loadData() {
		Session ses=null;
		ProductSalesInfo idVal=null,info=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Domain class obj
		idVal=new ProductSalesInfo();
		idVal.setCustId(2345); idVal.setProdId(101);
		//get /Load object
		info=ses.get(ProductSalesInfo.class,idVal);
		System.out.println(info.getProdId()+" "+info.getCustId()+" "+info.getCustName()+" "+" "+info.getProdName()+" "+info.getPrice());
		
		//close SEssion
		HibernateUtil.closeSession(ses);
	}

}
