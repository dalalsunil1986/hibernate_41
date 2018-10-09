package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.IplMatchInfo;
import com.nt.utility.HibernateUtil;

public class AnnoNamedHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query1=null,query2=null;
		List<IplMatchInfo> list=null;
		Transaction  tx=null;
		boolean flag=false;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  //get Access to Named HQL Query1
		 query1=ses.getNamedQuery("GET_ALL_MATCHES");
		 list=query1.list();
		 list.forEach(info->{
			 System.out.println(info.getMatchid()+"  "+info.getTitle()+" "+info.getLocation()+" "+info.getMatchDate()+" "+info.getFinalresult());
		 });
		 //get Access to Named HQL Query2
		 query2=ses.getNamedQuery("UPDATE_MATCH_LOC");
		 query2.setString("oldloc","pune");
		 query2.setString("newloc","jaipur");
		 count=query2.executeUpdate();
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
				System.out.println(" no.of records that are effeced:"+count);
			}
			else{
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
