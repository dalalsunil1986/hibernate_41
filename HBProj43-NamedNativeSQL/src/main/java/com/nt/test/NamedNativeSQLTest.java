package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.VoterInfo;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null,query1=null;
		List<VoterInfo> list=null;
		List<Object> list1=null;
		// Get session
		ses=HibernateUtil.getSession();
		try{
		//prpeare SQL Query
		query=ses.getNamedQuery("GET_VOTERINFO_BY_MPDIVS");
		//set values to query params
		query.setString("loc1","secundrabad");
		query.setString("loc2","delhi");
		query.setString("loc3","amethi");
		//second query
		query1=ses.getNamedQuery("GET_VOTERINFO_COUNT");
		list1=query1.list();
		
		 list=query.list();
		 list.forEach(info->{
			 System.out.println(info.getVoterId()+" "+info.getVoterName()+" "+info.getDob()+" "+info.getMlaDiv()+" "+info.getMpDiv());
		 });
		 
		 System.out.println("Records count::"+list1.get(0));
		 
		}
		catch(HibernateException he){
		}
		catch(Exception e){
		}
		finally{
		 //close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
