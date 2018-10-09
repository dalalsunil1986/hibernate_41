package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmployeeLOB;
import com.nt.utility.FileUtility;
import com.nt.utility.HibernateUtil;

public class EmployeeLOBDAOImpl implements EmployeeLOBDAO {

	@Override
	public void saveData()throws Exception {
		Session ses=null;
		String fileData=null;
		java.sql.Clob clb=null;
		LobHelper helper=null;
		byte bytes[]=null;
		java.sql.Blob blb=null;
		EmployeeLOB lob=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Convert CLOB file data java.sql.Clob obj
		helper=ses.getLobHelper();
		fileData=FileUtility.readFileAsString("C:\\Users\\NR\\Desktop\\init methods.txt");
		clb=helper.createClob(fileData);
		
		//Convert BLOB file data java.sql.Blob obj
		bytes=FileUtility.getBytesArrayFromFile("C:\\Users\\NR\\Desktop\\ramraj.jpg");
		blb=helper.createBlob(bytes);
		
		//prepare Domain class object
		lob=new EmployeeLOB();
		lob.setEname("ramraj");
		lob.setEphoto(blb);
		lob.setEresume(clb);
		
		try{
		 tx=ses.beginTransaction();
		  ses.save(lob);
		 flag=true;	
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Object saved");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}

	@Override
	public void loadData() {
		Session ses=null;
		EmployeeLOB lob=null;
		java.sql.Clob clb=null;
		java.sql.Blob blb=null;
		
		
		//get SEssion
		ses=HibernateUtil.getSession();
		try{
		  //load object
			lob=ses.get(EmployeeLOB.class, 1);
			System.out.println(lob.getEid()+" "+lob.getEname());
			//read Large objects
			clb=lob.getEresume();
			blb=lob.getEphoto();
			//Conver Lobs to files
			System.out.println(FileUtility.createFileFromClob(clb,"new_resume.txt"));
			System.out.println(FileUtility.createFileFromBlob(blb,"newLife.jpg"));
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
		

	}//method
}//class
