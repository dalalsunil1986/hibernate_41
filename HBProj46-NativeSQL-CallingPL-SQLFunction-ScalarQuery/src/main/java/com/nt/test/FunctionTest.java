package com.nt.test;

import java.util.List;

import com.nt.dao.VoterInfoDAO;
import com.nt.dao.VoterInfoDAOFactory;
import com.nt.domain.VoterInfo;
import com.nt.utility.HibernateUtil;

public class FunctionTest {

	public static void main(String[] args) {
		VoterInfoDAO dao=null;
		List<Object[]> list=null;
		//get DAO
		dao=VoterInfoDAOFactory.getInstance();
		//invoke method
		list=dao.getVotersDetailsByMpLoc("amethi");
		//process the result
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+"  ");
			}//for
			System.out.println();
		});//for
		//close objects
	  HibernateUtil.closeSessionFactory();
	}//main
}//class
