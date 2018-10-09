package com.nt.test;

import java.util.List;

import com.nt.dao.VoterInfoDAO;
import com.nt.dao.VoterInfoDAOFactory;
import com.nt.domain.VoterInfo;
import com.nt.utility.HibernateUtil;

public class ProcedureTest {

	public static void main(String[] args) {
		VoterInfoDAO dao=null;
		List<VoterInfo> list=null;
		//get DAO
		dao=VoterInfoDAOFactory.getInstance();
		//invoke method
		list=dao.getVotersDetailsByRange(1000, 1005);
		//process the result
		list.forEach(info->{
			System.out.println(info.getVoterId()+" "+info.getVoterName()+" "+info.getDob()+" "+info.getMlaDiv()+" "+info.getMpDiv());
		});
		//close objects
	  HibernateUtil.closeSessionFactory();
	}//main
}//class
