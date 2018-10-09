package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.IplMatchInfo;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest1 {

	public static void main(String[] args) {
		Session ses = null;
		Query query = null;
		List<IplMatchInfo> list = null;
		Iterator<IplMatchInfo> it=null;
		IplMatchInfo info=null;
		// Get Session object
		ses = HibernateUtil.getSession();

		/*
		 * //prepare Query object query=ses.createQuery("from IplMatchInfo");
		 * //execute the Query list=query.list(); //process the result
		 * for(IplMatchInfo info:list){
		 * System.out.println(info.getMatchid()+" "+info.getTitle()+" "+info.
		 * getLocation()+" "+info.getMatchDate()+" "+info.getFinalresult()); }
		 * list.forEach(info->{
		 * System.out.println(info.getMatchid()+" "+info.getTitle()+" "+info.
		 * getLocation()+" "+info.getMatchDate()+" "+info.getFinalresult()); });
		 */
		/*
		 * //Prepare HQL Query haiving Positional params query=ses.
		 * createQuery("from IplMatchInfo where matchid>=? and matchid<=?");
		 * //query=ses.
		 * createQuery("from IplMatchInfo where matchid>=?1 and matchid<=?2");
		 * // query=ses.
		 * createQuery("from IplMatchInfo where matchid>=:min and matchid<=:max"
		 * ); //set values to query param query.setInteger(0, 1001);
		 * query.setInteger(1,1010); query.setInteger("min",1001);
		 * query.setInteger("max",1010); //execute the query list=query.list();
		 * //process the result list.forEach(info->{
		 * System.out.println(info.getMatchid()+" "+info.getTitle()+" "+info.
		 * getLocation()+" "+info.getMatchDate()+" "+info.getFinalresult()); });
		 */

	/*	// we can place both named and positional params in HQL Query
		query = ses.createQuery("from IplMatchInfo where finalresult in(?,?,:t3)");
		// set values to quer params
		query.setString(0, "SRH");
		query.setString(1, "CSK");
		query.setString("t3", "KKR");
		// execute the query
		list = query.list();
		// process the result
		list.forEach(info -> {
			System.out.println(info.getMatchid() + " " + info.getTitle() + " " + info.getLocation() + " "
					+ info.getMatchDate() + " " + info.getFinalresult());
		});
		*/
		//executing HQL Selet query using iterate() method
		query=ses.createQuery("from IplMatchInfo where title like :versus");
		//set query param values
		query.setString("versus","%Vs%MI");
		//exeute query
		it=query.iterate();
		//process the result
		/*while(it.hasNext()){
			info=it.next();
			System.out.println(info.getClass());
			System.out.println(info.getMatchid() + " " + info.getTitle() + " " + info.getLocation() + " "
					+ info.getMatchDate() + " " + info.getFinalresult());
		}*/

		// close session
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}// main
}// class
