package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.nt.domain.VoterInfo;
import com.nt.utility.HibernateUtil;

public class NativeSQLSelectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		List<Object[]> list=null;
		List<VoterInfo> list1=null;
		List<?> list2=null;
		Iterator it=null;
		VoterInfo info=null;
		
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare NativeSQL Query (Entity)
		/*query=ses.createSQLQuery("SELECT * FROM  VOTERINFO");
		//execute the Query
		list=query.list();
		//process the Result
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+" ");
			}//for
			System.out.println();
		});//method call
*/		
	/*	query=ses.createSQLQuery("SELECT * FROM  VOTERINFO");
		//map Entity results with Domain class
		query.addEntity(VoterInfo.class);
		//execute the Query
		list1=query.list();
		//process the Result
		list1.forEach(info->{
			System.out.println(info.getVoterId()+"  "+info.getVoterName()+" "+info.getDob()+" "+info.getMlaDiv()+" "+info.getMpDiv());
		});*/
		
		/*//prepare NativeSQL Scalar query
		query=ses.createSQLQuery("SELECT VOTERID,VOTERNAME FROM VOTERINFO WHERE MLADIV=:loc");
		query.setString("loc","sanathnagar");
		query.addScalar("VOTERID",StandardBasicTypes.INTEGER);
		query.addScalar("VOTERNAME",StandardBasicTypes.STRING);
		list=query.list();
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+" "+val.getClass());
			}
			System.out.println();
		});
		*/
		
		//prepare SQL Query
		/*query=ses.createSQLQuery("select count(*) from VoterInfo");
		query.addScalar("count(*)",StandardBasicTypes.INTEGER);
		list2=query.list();
		int count=(Integer)list2.get(0);
		System.out.println("count is::"+count);
		*/
		//prepare SQL Query
		query=ses.createSQLQuery("SELECT * FROM  VOTERINFO");
		//map Entity results with Domain class
		query.addEntity(VoterInfo.class);
		//execute the Query
		it=query.iterate();
		//process the Result
		while(it.hasNext()){
			info=(VoterInfo)it.next();
			System.out.println(info.getVoterId()+" "+info.getVoterName()+" "+info.getDob()+" "+info.getMlaDiv()+" "+info.getMpDiv());
		}
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
