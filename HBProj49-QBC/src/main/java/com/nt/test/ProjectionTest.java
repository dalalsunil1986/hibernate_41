package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nt.domain.SocialRanking;
import com.nt.utility.HibernateUtil;

public class ProjectionTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null,p2=null,p3=null;
		ProjectionList pList=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Criteria
		criteria=ses.createCriteria(SocialRanking.class);
		//prpeare Projections
		p1=Projections.property("sno");
		p2=Projections.property("socialRank");
		p3=Projections.property("personName");
		//add all Projections to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		criteria.setProjection(pList);
		//execute QBC logic
		list=criteria.list();
		//process the resutls
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+"  ");
			}//for
			System.out.println();
		});
		
		//close objects
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}//main
}//class
