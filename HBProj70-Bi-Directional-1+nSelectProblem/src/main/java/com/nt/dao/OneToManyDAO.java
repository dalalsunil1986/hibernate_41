package com.nt.dao;

public interface OneToManyDAO {
	public void saveDataUsingUserDetails();
	public void  saveDataUsingPhoneNumber();
	public void loadDataUsingUserDetails();
	public  void  loadDataUsingPhoneNumber();
	public void loadDataUsingUserDetailsAndJoins();
	public  void  loadDataUsingPhoneNumberAndQBC();
	public void  loadDataUsingQBC();
	
    
}
