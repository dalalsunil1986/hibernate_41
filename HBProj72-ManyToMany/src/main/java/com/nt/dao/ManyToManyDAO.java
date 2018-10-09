package com.nt.dao;

public interface ManyToManyDAO {
	public void saveDataUsingProgrammer();
	public void saveDataUsingProject();
	public void loadDataUsingProgrammer(); 
	public void loadDataUsingProject();
	public  void relieveProgramerFromAProject();
	public void  AssignExistingProgrammerToExistingProject();
	public void transferProject();

}
