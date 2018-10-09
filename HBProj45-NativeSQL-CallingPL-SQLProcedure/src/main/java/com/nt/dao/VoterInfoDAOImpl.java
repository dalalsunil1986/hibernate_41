package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.VoterInfo;
import com.nt.utility.HibernateUtil;

public class VoterInfoDAOImpl implements VoterInfoDAO {
	

	@Override
	public List<VoterInfo> getVotersDetailsByRange(int startId, int endId) {
	   List<VoterInfo> list=null;
	   Query query=null;
	   Session ses=null;
	   try{
	   //get Access to Session
	   ses=HibernateUtil.getSession();
	   //get Access to NamedSQL query
	   query=ses.getNamedQuery("CALL_PROCEDURE");
	   //set values to query params
	  /* query.setInteger("min",startId);
	   query.setInteger("max",endId);*/
	   query.setInteger(0,startId);
	   query.setInteger(1,endId);
	   
	   //execute the query
	   list=query.list();
	   }
	   catch(HibernateException he){
		   he.printStackTrace();
	   }
	   finally{
		   HibernateUtil.closeSession(ses);
	   }
		return list;
	}

}
