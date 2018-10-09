package com.nt.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		prgmr1=new Programmer();
		prgmr1.setPname("raja");
		prgmr1.setSalary(9000);
		
		prgmr2=new Programmer();
		prgmr2.setPname("mahesh");
	    prgmr2.setSalary(8000);
	    
	    prgmr3=new Programmer();
		prgmr3.setPname("ramesh");
	    prgmr3.setSalary(7000);
	    
	    proj1=new Project();
	    proj1.setProjName("proj1");
	    proj1.setTeamSize(10);
	    
	    proj2=new Project();
	    proj2.setProjName("proj2");
	    proj2.setTeamSize(20);
	    
	    //add Projects to programmers
	    prgmr1.getProjects().add(proj1);
	    prgmr1.getProjects().add(proj2);
	    
	    prgmr2.getProjects().add(proj1);
	    prgmr2.getProjects().add(proj2);
	    
	    prgmr3.getProjects().add(proj2);
	    //add Programmers to Project
	    proj1.getProgrammers().add(prgmr1);
	    proj1.getProgrammers().add(prgmr2);
	    
	    proj2.getProgrammers().add(prgmr1);
	    proj2.getProgrammers().add(prgmr2);
	    proj2.getProgrammers().add(prgmr3);
	    
		try{
		 tx=ses.beginTransaction();	
            ses.save(prgmr1);
            ses.save(prgmr2);
            ses.save(prgmr3);
		 flag=true;	
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally

	}//method
}//class
