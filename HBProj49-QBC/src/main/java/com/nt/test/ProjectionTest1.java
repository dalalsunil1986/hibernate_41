package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nt.domain.SocialRanking;
import com.nt.utility.HibernateUtil;

public class ProjectionTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null,p2=null,p3=null,p4=null;
		ProjectionList pList=null;
		List<Object[]> list=null;
		Object row[]=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create Criteria obj
		criteria=ses.createCriteria(SocialRanking.class);
		//preare Projections
		p1=Projections.rowCount();
		p2=Projections.max("sno");
		p3=Projections.min("sno");
		p4=Projections.avg("sno");
		//add Projections to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1); pList.add(p2);
		pList.add(p3); pList.add(p4);
		// set Projections to Criteria API
		criteria.setProjection(pList);
		//execute QBC logic
		list=criteria.list();
		//process the Result
		row=list.get(0);
		System.out.println("row Count::"+row[0]);
		System.out.println("max sno col vlaue::"+row[1]);
		System.out.println("min sno col value::"+row[2]);
		System.out.println("avg sno col vlaue::"+row[3]);
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}//main
}//class
