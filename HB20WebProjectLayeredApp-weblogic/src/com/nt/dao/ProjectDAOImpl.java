package com.nt.dao;

import org.hibernate.Session;

import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public Project getProject(int pid) {
		Session ses=null;
		Project proj=null;
		//get Session
		ses=HibernateUtil.getSession();
		System.out.println("hashCode of Session obj:"+ses.hashCode());
		//load object
		proj=ses.get(Project.class,pid);
		
		return proj;
	}//method

}
