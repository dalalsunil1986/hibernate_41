package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class FullObjectUpdateTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		Transaction tx=null;
		boolean flag=false;
		//create Configuration object
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SessionFactory object
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//create domain obj with old id value and new other values
		policy=new InsurancePolicy();
		policy.setPolicyId(1004);
		policy.setPolicyName("JA+++");
		policy.setCompany("LICInd");
		policy.setTenure(20);
		policy.setPremium(5100);
		try{
		  tx=ses.beginTransaction();
		    ses.update(policy);
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
				System.out.println("Record found and updated");
			}
			else{
				tx.rollback();
				System.out.println("Record not found ");
			}
		 //close objs
			ses.close();
			factory.close();
		}//finally
	}//main
}//class
