package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nt.domain.SocialRanking;
import com.nt.utility.HibernateUtil;

public class OrderTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		Criterion cond=null;
		Order ord=null;
		List<SocialRanking> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create QBC logic (Criteria)
		criteria=ses.createCriteria(SocialRanking.class);
		//prepare Criterion obj
        cond=Restrictions.between("sno",1,50);
        //add criterion obj
        criteria.add(cond);
        //Prepare Order
        //ord=Order.desc("address");
        ord=Order.asc("address");
        //add Order
         criteria.addOrder(ord);
        //execute QBC logic
        list=criteria.list();
        //process the result
        list.forEach(sr->{
        	System.out.println(sr.getSno()+" "+sr.getAadharNo()+" "+sr.getPersonName()+" "+sr.getAddress()+" "+sr.getSocialRank());
        });
        //close objs
        HibernateUtil.closeSession(ses);
        HibernateUtil.closeSessionFactory();
	}//main
}//class
