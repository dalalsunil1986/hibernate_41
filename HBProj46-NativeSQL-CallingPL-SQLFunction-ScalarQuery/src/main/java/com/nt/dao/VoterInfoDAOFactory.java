package com.nt.dao;

public class VoterInfoDAOFactory {
  public static VoterInfoDAO getInstance(){
	  return new VoterInfoDAOImpl();
  }
	
}
