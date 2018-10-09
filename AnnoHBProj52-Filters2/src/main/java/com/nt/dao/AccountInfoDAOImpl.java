package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.domain.AccountInfo;
import com.nt.utility.HibernateUtil;

public class AccountInfoDAOImpl implements AccountInfoDAO {

	@Override
	public void getAllAccountDetailsAndBalnaceSum() {
		Session ses=null;
		Filter filter=null;
		Query query=null;
		List<AccountInfo>list=null;
		List<Object> list1=null;
		Criteria criteria=null;
		Projection p1=null;
		SQLQuery query1=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create Filter
		filter=ses.enableFilter("HB_INACTIVE_ACCOUNTS");
		filter.setParameter("acno1",1001);
		filter.setParameter("acno2",1003);
		filter.setParameter("acno3",1024);
		//create Query
		query=ses.createQuery("from AccountInfo");
		//execute Query
		list=query.list();
		//process the result
		list.forEach(info->{
			System.out.println(info.getAcno()+" "+info.getHolder()+" "+info.getBalance());
		});
		// prepare Native SQL Query
		query1=ses.createSQLQuery("select * from AccountInfo");
		query1.addEntity(AccountInfo.class);
		list=query1.list();
		//process the result
		list.forEach(info->{
			System.out.println(info.getAcno()+" "+info.getHolder()+" "+info.getBalance());
		});
		
		
		//disable Filer
		ses.disableFilter("HB_INACTIVE_ACCOUNTS");
		//create Criteria
		criteria=ses.createCriteria(AccountInfo.class);
		//create Projection
		p1=Projections.sum("balance");
		criteria.setProjection(p1);
		//execute logic
		list1=criteria.list();
		System.out.println("Sum of Account's balnace:: "+list1.get(0));
		
		
		//close Session
		HibernateUtil.closeSession(ses);
	}

}
