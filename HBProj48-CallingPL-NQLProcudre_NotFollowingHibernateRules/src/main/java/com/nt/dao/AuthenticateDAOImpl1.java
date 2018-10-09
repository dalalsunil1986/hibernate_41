package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthenticateDAOImpl1 implements AuthenticateDAO {
 private static final String CALL_AUTH_QUERY="{CALL P_AUTHENTICATION(?,?,?)}";
	@Override
	public String authenticate(String username, String pwd) {
		Session ses=null;
		String result=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Connection
		result=ses.doReturningWork(new ReturningWork<String>() {

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
				cs.setString(2,pwd);
				//execute PL/SQL Procedure
				cs.execute();
				//gather results from OUT params
				result=cs.getString(3);
				return result;
			}//method
		}//anomous inner class
		);//method call
		
		
		//close session
		HibernateUtil.closeSession(ses);
			
	
		return result;
	}
	
}//outer class
