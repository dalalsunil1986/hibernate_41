package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.IplMatchInfo;
import com.nt.utility.HibernateUtil;

public class PaginationTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<IplMatchInfo> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from IplMatchInfo");
		query.setFirstResult(6); //start pos
		query.setMaxResults(3); //pageSize
		//execute the query
		list=query.list();
		//process the list
		list.forEach(info->{
			System.out.println(info.getMatchid()+" "+info.getTitle()+" "+info.getLocation()+" "+info.getFinalresult());
		});
		
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}
}
