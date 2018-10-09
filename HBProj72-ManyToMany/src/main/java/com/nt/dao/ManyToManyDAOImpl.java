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
	public void saveDataUsingProgrammer() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		 //prepare Parent objs
		  prgmr1=new Programmer();
		   prgmr1.setPname("raja"); prgmr1.setSalary(9000);

		  prgmr2=new Programmer();
		   prgmr2.setPname("rani"); prgmr2.setSalary(8000);

		 prgmr3=new Programmer();
		   prgmr3.setPname("ramesh"); prgmr3.setSalary(8000);

		  //prepare child objs
		  proj1=new Project();
		  proj1.setProjname("OpenFx");
		  proj1.setTeamsize(6);

		  proj2=new Project();
		  proj2.setProjname("Amex");
		  proj2.setTeamsize(6);

		//add Projects to Programmers
		   prgmr1.getProjects().add(proj1);
		   prgmr1.getProjects().add(proj2);
		   
		  prgmr2.getProjects().add(proj2);

		    prgmr3.getProjects().add(proj1);
		   prgmr3.getProjects().add(proj2);
		 //add Programemrs to Projects
		   proj1.getProgrammers().add(prgmr1);
		   proj1.getProgrammers().add(prgmr3);
		   
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
	
	@Override
	public void loadDataUsingProgrammer() {
		Session ses=null;
        Query query=null;
        List<Programmer> list=null;
        try{
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Programmer");
		list=query.list();
		list.forEach(prgmr->{
			System.out.println("parent-->"+prgmr.getPid()+" "+prgmr.getPname()+" "+prgmr.getSalary());
			Set<Project> childs=prgmr.getProjects();
			childs.forEach(proj->{
				System.out.println("child -->"+proj.getProjid()+" "+proj.getProjname()+" "+proj.getTeamsize());
			});
		});
        }//try
    	catch(HibernateException he){
			he.printStackTrace();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadDataUsingProject() {
		Session ses=null;
        Query query=null;
        List<Project> list=null;
        try{
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Project");
		list=query.list();
		list.forEach(proj->{
			System.out.println("child -->"+proj.getProjid()+" "+proj.getProjname()+" "+proj.getTeamsize());
			Set<Programmer> parents=proj.getProgrammers();
			parents.forEach(prgmr->{
				System.out.println("parent-->"+prgmr.getPid()+" "+prgmr.getPname()+" "+prgmr.getSalary());
			});
		});
        }//try
    	catch(HibernateException he){
			he.printStackTrace();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void relieveProgramerFromAProject() {
		Session ses=null;
        Query query=null;
        Programmer prgmr=null;
        Set<Project> childs=null;
        Set<Programmer> parents=null;
        Project proj=null;
        Transaction tx=null;
        boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load a Programmer
		prgmr=ses.get(Programmer.class,4);
		//get Projects of a Programmer
		childs=prgmr.getProjects();
		//Load the Project that u want to delete
		proj=ses.get(Project.class,104);
		parents=proj.getProgrammers();
		try{
		 tx=ses.beginTransaction();
		   childs.remove(proj);
		   parents.remove(prgmr);
		 flag=true;
		}
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Programmer is relieved");
			}
			else{
				tx.rollback();
				System.out.println("Programmer is not relieved");
			}
		}//finally
		HibernateUtil.closeSession(ses);
	}//method
	
	@Override
	public void AssignExistingProgrammerToExistingProject() {
		Session ses=null;
        Set<Programmer> childs=null;
        Project proj=null;
        Transaction tx=null;
        Programmer prgmr=null;
        boolean flag=false;
        // get Session
        ses=HibernateUtil.getSession();
        //Load Existing Project
        proj=ses.get(Project.class,104);
        //get all Programmers of above Project
        childs=proj.getProgrammers();
        //Load existing Programmer
        prgmr=ses.get(Programmer.class,2);
        try{
          tx=ses.beginTransaction();
           childs.add(prgmr);
          flag=true;
        }
        catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Programmer is added to the Project");
			}
			else{
				tx.rollback();
				System.out.println("Programmer is not added to the project");
			}
		}//finally
	}//method
	
	@Override
	public void transferProject() {
		Session ses=null;
        Set<Programmer> projPrgmrs=null;
        Project proj=null;
        Transaction tx=null;
        Programmer prgmr1=null,prgmr2=null;
        boolean flag=false;
        Set<Project> prgmr1Projs=null,prgmr2Projs=null;
        // get Session
        ses=HibernateUtil.getSession();
        //Load Source PRogrammer
        prgmr1=ses.get(Programmer.class, 1);
        //Load Dest PRogrammer
        prgmr2=ses.get(Programmer.class, 5);
        //Load Project
        proj=ses.get(Project.class,100);
        //get Projects  Soruce and Dest programmers
        prgmr1Projs=prgmr1.getProjects();
        prgmr2Projs=prgmr2.getProjects();
        projPrgmrs=proj.getProgrammers();
        try{
         tx=ses.beginTransaction();
           prgmr1Projs.remove(proj);
           prgmr2Projs.add(proj);
           projPrgmrs.remove(prgmr1);
           projPrgmrs.add(prgmr2);
         flag=true;
        }
        catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Programmer is transffered");
			}
			else{
				tx.rollback();
				System.out.println("Programmer is not transffered");
			}
		}//finally
        HibernateUtil.closeSession(ses);
	}//method
}//class
