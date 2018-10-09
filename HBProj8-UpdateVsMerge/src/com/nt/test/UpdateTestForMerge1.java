package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.TicketDetails;
import com.nt.utitlity.HibernateUtil;

public class UpdateTestForMerge1 {

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
		details1.setPrice(1000);
		
		details2=new TicketDetails();
		details2.setAadharNo(1231);
		details2.setTtktId(1112);
		details2.setMatchName("IND Vs PAK-P");
		details2.setMatchDate(new Date());
		details2.setPrice(100000);
		
		try{
		  tx=ses.beginTransaction();	
		   ses.save(details1);
		   //ses.save(details2);
		details3=(TicketDetails) ses.merge(details2);
		System.out.println(details1.hashCode()+" "+details2.hashCode()+" "+details3.hashCode());
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
