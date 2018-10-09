package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.ProdCustId;
import com.nt.domain.ProductSalesInfo;
import com.nt.utility.HibernateUtil;

public class ProductSalesDAOImpl implements ProductSalesInfoDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ProductSalesInfo info=null;
		ProdCustId cid=null,idVal=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//preare cid value
		cid=new ProdCustId();
		cid.setProdId(9002);
		cid.setCustId(2367);
		//Domain class obj
		info=new ProductSalesInfo();
		//set cid to Domain class obj
		info.setCid(cid);
		info.setCustName("raja");
        info.setProdName("d.kanthi");
		info.setPrice(20);
		try{
		  tx=ses.beginTransaction();
		  idVal=(ProdCustId)ses.save(info);
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
		ProductSalesInfo prod=null;
		ProdCustId id=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Domain class obj
		id=new ProdCustId();
		id.setCustId(2367);
		id.setProdId(9002);
		//get /Load object
		prod=ses.get(ProductSalesInfo.class,id);
		System.out.println(prod.getCid().getProdId()+" "+prod.getCid().getCustId()+" "+prod.getProdName()+" "+prod.getCustName()+" "+prod.getPrice());
		
		//close SEssion
		HibernateUtil.closeSession(ses);
	}//main
}//class
