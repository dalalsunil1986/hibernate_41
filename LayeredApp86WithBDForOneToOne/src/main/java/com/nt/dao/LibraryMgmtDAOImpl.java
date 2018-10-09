package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class LibraryMgmtDAOImpl implements LibraryMgmtDAO {
	private static final String HQL_GET_STUDS_WITH_LIB_DETAILS="from Student";

	@Override
	public List<Student> getStudentsWithLibraryMembershipDetails() {
		Session ses=null;
		Query query=null;
		List<Student> listStuds;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare query
		query=ses.createQuery(HQL_GET_STUDS_WITH_LIB_DETAILS);
		//execute the Query
		listStuds=query.list();
		return listStuds;
	}
	
	@Override
	public int deleteStudentWithLibraryLibraryDetails(int sid) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Student stud=null;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		//Load Student obj
		stud=ses.get(Student.class,sid);
		try{
		 tx=ses.beginTransaction();	
			ses.delete(stud);
		 flag=true;
		 count=1;
		}
		catch(HibernateException he){
			flag=false;
			count=0;
			throw he;
		}
		finally{
			if(flag){
				tx.commit();
			}
			else{
				tx.rollback();
			}
		}
		return count;
	}//method
	
	@Override
	public int insertStudent(Student stud) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		int id=0;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();	
			id=(Integer)ses.save(stud);
         flag=true;		
		}
		catch(HibernateException he){
			flag=false;
			id=0;
			throw he;
		}
		finally{
			if(flag){
				tx.commit();
			}
			else{
				tx.rollback();
			}
		}
		return id;
	}//method
	
}//class
