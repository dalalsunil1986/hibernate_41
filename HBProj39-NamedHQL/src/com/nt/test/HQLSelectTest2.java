package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.IplMatchInfo;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest2 {

	public static void main(String[] args) {
		Session ses = null;
		Query query = null;
		List<Object[]> list=null;
		List<String> list1=null;
		List<Object> list2=null;
		List<Object[]>list3=null;
		List<IplMatchInfo> list4=null;
		Object row[]=null;
		long count=0;
		IplMatchInfo info=null;
		
		
		// Get Session object
		ses = HibernateUtil.getSession();
		//retrieving specific mulitple col values from Db table
		query=ses.createQuery("select matchid,title,finalresult from IplMatchInfo");
		//execute query
		//list=query.list();
		//process the result
		/*for(Object[] row:list){
			for(Object val:row){
				System.out.print(val+"   ");
			}//for
			System.out.println();
		}//for
*/	
		/*list.forEach(row->{
			for(Object val:row){
				System.out.print(val+"  ");
			}//for
			System.out.println();
		});*/
		
		/*Iterator<Object[]> it=query.iterate();
		while(it.hasNext()){
			Object row[]=it.next();
			for(Object val:row){
				System.out.print(val+"  ");
			}
			System.out.println();
		}*/
		
		/*//Retrieving specific single col value from DB table
		query=ses.createQuery("select title from IplMatchInfo where location=:loc");
		//set named param value
		query.setString("loc","hyd");
		//execute Query
		list1=query.list();
		//process the Result
		list1.forEach(title->{
			System.out.println(title);
		});*/
		
	/*	//executing select Query with arrgration
		query=ses.createQuery("select count(*) from IplMatchInfo");
		//execute Query
		list2=query.list();
		//process the result
		count=(Long)list2.get(0);
		System.out.println("Count of records:::"+count);
		*/
	   //executing HQL select Query with multiple aggrate functions
		/*query=ses.createQuery("select count(*),max(matchid),min(matchid),sum(matchid),avg(matchid) from IplMatchInfo");
		list3=query.list();
		row=list3.get(0);
		System.out.println("records count::"+row[0]);
		System.out.println("max value of match id val::"+row[1]);
		System.out.println("min value of match id val::"+row[2]);
		System.out.println("sum value of match id val::"+row[3]);
		System.out.println("avg value of match id val::"+row[4]);
		*/
		//executing HQL sub queries
		/*query=ses.createQuery("from IplMatchInfo where matchid=(select max(matchid) from IplMatchInfo)");
		list4=query.list();
		info=list4.get(0);
		System.out.println(info.getMatchid()+"  "+info.getTitle()+"  "+info.getLocation()+" "+info.getMatchDate()+" "+info.getFinalresult());
		
		*/
		

		// close session
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}// main
}// class
