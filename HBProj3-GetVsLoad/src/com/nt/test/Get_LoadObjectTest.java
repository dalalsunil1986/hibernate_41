package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.CourseDetails;

public class Get_LoadObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		CourseDetails details=null;
		//BootStarpping hibernate
		cfg=new Configuration();
		//read Cfg ,mapping files
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Create SessionFactory object
		factory=cfg.buildSessionFactory();
		//create SEssion
		ses=factory.openSession();
		//Load object
		try{
		 details=ses.get(CourseDetails.class,101);
		 if(details==null)
			 System.out.println("Record not found");
		 else{
			 System.out.println("Object found");
			 System.out.println(details.getCourseId()+" "+details.getCourseName()+" "+details.getFaculty()+" "+details.getDuration()+" "+details.getFee()+" "+details.isStatus());
		 }
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close objs
			ses.close();
			factory.close();
		}
	}//main
}//class
