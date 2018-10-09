package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class BasicSaveTest {

	public static void main(String[] args) {
		System.out.println("main(-) method....");
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		// Activate HB framework/BootStraping hibernate
        cfg=new Configuration();
        //set HB Configuration properties
        cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
        
        cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
        cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
        cfg.setProperty("hibernate.connection.username","system");
        cfg.setProperty("hibernate.connection.password","manager");
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        
        //set mapping file name
        cfg.addFile("src/com/nt/domain/Employee.hbm.xml");
        //create SessionFactory object
        factory=cfg.buildSessionFactory();
        
        
        //create HB Session object
        ses=factory.openSession();
        System.out.println("session obj class name::"+ses.getClass());
        
        //prepared Domain class object
        emp=new Employee();
        emp.setEid(1059); emp.setFirstName("Raja");
        emp.setLastName("chari"); emp.setEmail("chari@gmail.com");
        //emp.setSalary(78890);
        System.out.println("----------------------");
        
        try{
        //Begin Tx
         tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
           //save object
           idVal=(Integer)ses.save(emp);
           System.out.println("Id value::"+idVal);
           System.out.println("-------------------");
         flag=true;
        }
        catch(HibernateException he){
        	he.printStackTrace();
        	flag=false;
        }
        catch(Exception e){
        	e.printStackTrace();
        	flag=false;
        }
        finally{
        	if(flag==true){
        		tx.commit(); //Internally calls con.commit()
        		System.out.println("Object is saved");
        	}
        	else{
        		//tx.rollback();  //Internally calls con.rollback()
        		System.out.println("Object is not saved");
        	}
        	//close session
        	ses.close();
        	//close sessionfactory
        	factory.close();
        }///finally
	}//main
}//class
