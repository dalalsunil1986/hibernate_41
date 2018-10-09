package com.nt.test;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Tourist;
import com.nt.utility.HibernateUtil;

public class JPAGeneratorsTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Tourist tr=null;
		int idVal=0;
		//Get Session
		ses=HibernateUtil.getSession();
		try{
		 for(int i=1;i<=10;++i){	
		 tx=ses.beginTransaction();
		  tr=new Tourist();
		  tr.setTouristId(110);
		  tr.setTouristName("raja");
		  tr.setPlace("Alleppy");
		  tr.setDoj(new Date());
		  idVal=(int)ses.save(tr);
		  System.out.println("Generated id Value::"+idVal);
		 flag=true;
		 }//for
		}//try
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e){
			flag=false;
			e.printStackTrace();
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
		  //close  objs
		  HibernateUtil.closeSession(ses);
		  HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
