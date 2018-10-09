package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveDataUsingStudent() {
		Session ses=null;
		Student st=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		st=new Student();
		st.setSname("raja");
		st.setSadd("hyd");
		
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		lib.setMembershipType("platinum");
		//set parent to child and child to parent
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		try{
		 tx=ses.beginTransaction();
			 ses.save(st);	 
		flag=true;		 
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
		 e.printStackTrace();	
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
	
	@Override
	public void saveDataUsingLibraryMembership() {
		Session ses=null;
		Student st=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		st=new Student();
		st.setSname("ramesh");
		st.setSadd("vizag");
		
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		lib.setMembershipType("gold");
		//set parent to child and child to parent
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		try{
		 tx=ses.beginTransaction();
			ses.save(lib);	 
		flag=true;		 
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
		 e.printStackTrace();	
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
	
	@Override
	public void loadDataUsingStudent() {
		Session ses=null;
		List<Student> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare query
		query=ses.createQuery("from Student");
		try{
		  list=query.list();
		  /*list.forEach(st->{
			  System.out.println("parent::"+st.getSno()+" "+st.getSname()+" "+st.getSadd());
			  LibraryMembership lib=st.getLibraryDetails();
			  System.out.println("child:"+lib.getLib()+" "+lib.getDoj()+" "+lib.getMembershipType());
		  });*/
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingLibraryMembership() {
		Session ses=null;
		List<LibraryMembership> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare query
		query=ses.createQuery("from LibraryMembership");
		try{
		list=query.list();
		   list.forEach(lib->{

				  System.out.println("child:"+lib.getLib()+" "+lib.getDoj()+" "+lib.getMembershipType());
				  Student st=lib.getStudentDetails();
				  System.out.println("parent::"+st.getSno()+" "+st.getSname()+" "+st.getSadd());
				  
			  });
			}//try
			catch(HibernateException he){
				he.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				HibernateUtil.closeSession(ses);
			}//finally
	}//method
	
	@Override
	public void deleteDataUsingStudent() {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load Student object
		st=ses.get(Student.class,1);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(st);
		   flag=true;
		}//try
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
		 e.printStackTrace();	
		   flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("parent and its child deleted");
			}
			else{
				tx.rollback();
				System.out.println("parent and its child are not deleted");
			}
		//close Session
			HibernateUtil.closeSession(ses);
			
		}//finally
		
	}//method

	@Override
	public void deleteOnlyMemershipOfStudent() {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query object
		query=ses.createQuery("delete from LibraryMembership where lib=:id");
		query.setInteger("id",1);
		try{
			 tx=ses.beginTransaction();
			   int count=query.executeUpdate();
			   flag=true;
			}//try
			catch(HibernateException he){
				he.printStackTrace();
				flag=false;
			}
			catch(Exception e){
			 e.printStackTrace();	
			   flag=false;
			}
			finally{
				if(flag){
					tx.commit();
					System.out.println("Only child is deleted");
				}
				else{
					tx.rollback();
					System.out.println("Only child is not deleted");
				}
			//close Session
				HibernateUtil.closeSession(ses);
				
			}//finally
	}//method
	
}//class
