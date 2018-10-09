package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthenticateDAOImpl implements AuthenticateDAO {

	@Override
	public String authenticate(String username, String pwd) {
		Session ses=null;
		String result=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Connection
		result=ses.doReturningWork(new AuthReturningWork(username,pwd));
		//close session
		HibernateUtil.closeSession(ses);
			
	
		return result;
	}
	private static class AuthReturningWork implements ReturningWork<String>{
       private static final String CALL_AUTH_QUERY="{CALL P_AUTHENTICATION(?,?,?)}";
    private   String username;
     private  String password;
       
       public AuthReturningWork(String username,String pwd) {
	    this.username=username;
	    this.password=pwd;
	}
       
       
		@Override
		public String execute(Connection con) throws SQLException {
			CallableStatement cs=null;
			String result=null;
			//create CallableStatement obj
			cs=con.prepareCall(CALL_AUTH_QUERY);
			//register Out params with JDBC types
			cs.registerOutParameter(3, Types.VARCHAR);
			//set values to IN params
			cs.setString(1,username);
			cs.setString(2,password);
			//execute PL/SQL Procedure
			cs.execute();
			//gather results from OUT params
			result=cs.getString(3);
			
			
			return result;
			
		}//execute(-,-)
		
    }//inner class
}//outer class
