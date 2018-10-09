package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nt.domain.SocialRanking;
import com.nt.utility.HibernateUtil;

public class QBCTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		List<SocialRanking> list=null;
		Criterion cond=null,cond1=null,cond2=null,andCond=null,orCond=null;
		
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Criteria logic
		criteria=ses.createCriteria(SocialRanking.class);
	

	/*	// execute QBC logic
		list=criteria.list();

		//process the Result
		list.forEach(sr->{
			System.out.println(sr.getSno()+"  "+sr.getAadharNo()+" "+sr.getPersonName()+" "+sr.getAddress()+" "+sr.getSocialRank());
		});
		*/
		/* .......................................*/
	/*	//prepare Criterion (cond1)
		cond=Restrictions.between("sno", 1, 4);
		//add the condition
		criteria.add(cond);
		//execute QBC logic
		list=criteria.list();
		//process the Result
		list.forEach(sr->{
			System.out.println(sr.getSno()+"  "+sr.getAadharNo()+" "+sr.getPersonName()+" "+sr.getAddress()+" "+sr.getSocialRank());
		});*/
		/*......................................*/
		
	  /* //prepare conditions
		cond=Restrictions.in("address","hyd","delhi","chennai");
	    cond1=Restrictions.ge("socialRank",1);
	    cond2=Restrictions.le("socialRank",50);
	    //add them to Criteria Object
	    criteria.add(cond); 
	    criteria.add(cond1);
	    criteria.add(cond2);
	    //execute QBC Logic
	    list=criteria.list();
	    //process the result
	    list.forEach(sr->{
	    	System.out.println(sr.getSno()+" "+sr.getAadharNo()+" "+sr.getAddress()+" "+sr.getPersonName()+" "+sr.getSocialRank());
	    });*/
		/* ..................................... */
		//prepare conditions
		/*cond=Restrictions.ilike("personName","r%");
		cond1=Restrictions.ne("address","delhi");
		andCond=Restrictions.and(cond,cond1);
		cond2=Restrictions.like("address", "h%");
		orCond=Restrictions.or(andCond,cond2);
		//add the condition
		criteria.add(orCond);
		//execute QBC logic
		list=criteria.list();
		//process the result
		list.forEach(sr->{
			System.out.println(sr.getSno()+" "+sr.getAadharNo()+" "+sr.getAddress()+" "+sr.getPersonName()+" "+sr.getSocialRank());
		});*/
		
		//prepare condion
		cond=Restrictions.sqlRestriction("SOCIALRANK>=? and SOCIALRANK<=?",
				                        new Object[]{1,50},
				                         new Type[]{ StandardBasicTypes.INTEGER, 
				                        		     StandardBasicTypes.INTEGER});
		;
		
		//add the condition
				criteria.add(cond);
				//execute QBC logic
				list=criteria.list();
				//process the result
				list.forEach(sr->{
					System.out.println(sr.getSno()+" "+sr.getAadharNo()+" "+sr.getAddress()+" "+sr.getPersonName()+" "+sr.getSocialRank());
				});
		
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
