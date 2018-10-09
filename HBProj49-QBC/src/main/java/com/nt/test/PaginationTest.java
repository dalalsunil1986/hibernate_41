package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nt.domain.SocialRanking;
import com.nt.utility.HibernateUtil;

public class PaginationTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		List<SocialRanking> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Criteria
		criteria=ses.createCriteria(SocialRanking.class);
		//pagination settings
		criteria.setFirstResult(6);
		criteria.setMaxResults(3);
		//execute QBC logic
		list=criteria.list();
		//process the resutls
		list.forEach(sr->{
			System.out.println(sr.getSno()+" "+sr.getPersonName()+" "+sr.getAddress()+" "+sr.getAadharNo()+" "+sr.getSocialRank());
		});
		
		//close objects
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}//main
}//class
