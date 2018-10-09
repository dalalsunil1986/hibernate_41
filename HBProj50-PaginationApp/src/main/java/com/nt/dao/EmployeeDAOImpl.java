package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public long totalRecordsCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null;
		List<Object> list=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//create Criteria object
		criteria=ses.createCriteria(Employee.class);
		//create Project for RowCount
		p1=Projections.rowCount();
		criteria.setProjection(p1);
		//execute logic
		list=criteria.list();
	    return (Long) list.get(0);
	}

	@Override
	public List<Employee> reportData(int startPos, int pageSize) {
         Session ses=null;
         Criteria criteria=null;
         List<Employee> list=null;
		//get Session
         ses=HibernateUtil.getSession();
        //create Criteria object
         criteria=ses.createCriteria(Employee.class);
        //set pagination params
         criteria.setFirstResult(startPos);
         criteria.setMaxResults(pageSize);
         //execute QBC logic
         list=criteria.list();
		return list;
	}

}
