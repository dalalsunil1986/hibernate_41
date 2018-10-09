package com.nt.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {
	

	@Override
	public void saveData() {
		Session ses=null;
		Student stud=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		stud=new Student();
		stud.setSname("raja");
		stud.setSadd("hyd");
		
		lib=new LibraryMembership();
		lib.setType("gold");
		lib.setDoj(new Date());
		//set child to parent and parent to child
		stud.setLibraryDetails(lib);
		lib.setStudentDetails(stud);
		try{
		 tx=ses.beginTransaction();
		   ses.save(stud);
		 flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("objects are saved");
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
