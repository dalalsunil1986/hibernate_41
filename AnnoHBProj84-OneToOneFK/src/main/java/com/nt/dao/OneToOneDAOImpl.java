package com.nt.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.DrivingLicense;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person per1=null,per2=null;
		DrivingLicense license=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		per1=new Person();
		per1.setPname("raja");
		per1.setAddress("hyd");
		
		per2=new Person();
		per2.setPname("rani");
		per2.setAddress("vizag");
		
		license=new DrivingLicense();
		license.setType("2-Wheeler");
		license.setValidFrom(new Date());
		license.setValidTo(new Date(138,6,3));
		license.setLicenseHolder(per1);
		try{
		 tx=ses.beginTransaction();
		   ses.save(license);
		   ses.save(per2);
		 flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");	
			}
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
}//class
