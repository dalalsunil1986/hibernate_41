package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.TicketDetails;
import com.nt.utitlity.HibernateUtil;

public class UpdateTestForMerge2 {

	public static void main(String[] args) {
		Session ses=null;
		TicketDetails details1=null,details2=null,details3=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prpeare objects
		details1=new TicketDetails();
		details1.setAadharNo(1231);
		details1.setTtktId(3445);
		details1.setMatchName("IND Vs PAK-N");
		details1.setMatchDate(new Date());
		details1.setPrice(2500);
		//Load object
		details2=ses.get(TicketDetails.class, 1231);
		
		try{
		  tx=ses.beginTransaction();
		  details2.setPrice(3000);
		  //ses.update(details1);
		  ses.merge(details1);
		  flag=true;
		}
		catch(HibernateException se){
			se.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Ticket booked");
			}
			else{
				tx.rollback();
				System.out.println("Ticket not booked");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
