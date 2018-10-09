package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.CourseDetails;
import com.nt.domain.ICourseDetails;

public class Load_Proxy_LoadObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		ICourseDetails details=null;
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
		 details=ses.load(ICourseDetails.class,101);
		 details.getCourseName();
		 System.out.println(details.getClass()+".."+details.getClass().getSuperclass()+".."+Arrays.toString(details.getClass().getInterfaces()));
		 //System.out.println(details.getCourseId()+" "+details.getCourseName()+" "+details.getDuration()+" "+details.getFaculty()+" "+details.getFee());
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
