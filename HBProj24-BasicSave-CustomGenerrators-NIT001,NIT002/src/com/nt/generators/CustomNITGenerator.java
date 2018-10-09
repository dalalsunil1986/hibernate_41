package com.nt.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomNITGenerator implements IdentifierGenerator {
  private static final String CALL_NIT_SEQUENCE="SELECT NIT_SEQ.NEXTVAL FROM DUAL";
	@Override
	public Serializable generate(SessionImplementor ses, Object domain) throws HibernateException {
 		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int val=0;
		try{
		//get Connection obj
		con=ses.connection();
		//create PreparedStatement object
		ps=con.prepareStatement(CALL_NIT_SEQUENCE);
		//execute Query
		rs=ps.executeQuery();
		//gather results
		if(rs.next())
			val=rs.getInt(1);
		if(val<=9)
			return "NIT000"+val;
		else if(val<=99)
			return "NIT00"+val;
		else if(val<=999)
			return "NIT0"+val;
		else 
			return "NIT"+val;
		}
		catch(SQLException se){
			se.printStackTrace();
			return "Could not generate Id";
		}
		catch(Exception e){
			e.printStackTrace();
			return "Could not generated Id";
		}
	}//generate(-,-)
}//class
