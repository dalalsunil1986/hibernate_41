package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.IplMatchInfo;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<IplMatchInfo> list=null;
		Transaction  tx=null;
		boolean flag=false;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		/*//get Acces to Named Query
		query=ses.getNamedQuery("GET_MATCHES_BY_LOC");
		//set param values
		query.setString("loc","hyd");
		//execute Query
	    list=query.list();
	    //process the result
	    list.forEach(info->{
	    	System.out.println(info.getMatchid()+" "+info.getTitle()+" "+info.getLocation()+" "+info.getFinalresult());
	    });*/
			
		/*//get Acces to Named Query
		query=ses.getNamedQuery("GET_MATCHES_BY_IDS");
			//set param values
			query.setInteger("min",1000);
			query.setInteger("max",1010);
			//execute Query
		    list=query.list();
		    //process the result
		    list.forEach(info->{
		    	System.out.println(info.getMatchid()+" "+info.getTitle()+" "+info.getLocation()+" "+info.getFinalresult());
		    });	*/
			
			//get Acces to Named Query
			query=ses.getNamedQuery("DELETE_MATCHES_BY_LOC");
				//set param values
				query.setString("loc","hyd");
			tx=ses.beginTransaction();
			  count=query.executeUpdate();
			flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
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
