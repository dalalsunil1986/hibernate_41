package com.nt.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

		@Override
	public void saveDataUsingProject() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null;
		Project proj1=null,proj2=null,proj3=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		 //prepare Parent objs
		  prgmr1=new Programmer();
		   prgmr1.setPname("jani"); prgmr1.setSalary(9000);

		  prgmr2=new Programmer();
		   prgmr2.setPname("dhoni"); prgmr2.setSalary(8000);

		
		  //prepare child objs
		  proj1=new Project();
		  proj1.setProjname("Amerprise");
		  proj1.setTeamsize(10);

		  proj2=new Project();
		  proj2.setProjname("airbus");
		  proj2.setTeamsize(10);
		  
		  proj3=new Project();
		  proj3.setProjname("redbus");
		  proj3.setTeamsize(10);
		  

		//add Projects to Programmers
		   prgmr1.getProjects().add(proj1);
		   prgmr1.getProjects().add(proj2);
		   prgmr1.getProjects().add(proj3);
		   
		  prgmr2.getProjects().add(proj2);
		  prgmr2.getProjects().add(proj3);

		  
		 //add Programemrs to Projects
		   proj1.getProgrammers().add(prgmr1);
		   
		   
		   proj2.getProgrammers().add(prgmr1);
		   proj2.getProgrammers().add(prgmr2);
		   
		   proj3.getProgrammers().add(prgmr1);
		   proj3.getProgrammers().add(prgmr2);

		
		try{
		  tx=ses.beginTransaction();
		    ses.save(proj1);
		    ses.save(proj2);
		    ses.save(proj3);
		  flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
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
		}

	}//method
	
}//class
