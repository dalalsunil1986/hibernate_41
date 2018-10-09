package com.nt.dao;

public interface ManyToOneDAO {
	public void saveData();
	public void loadData();
	public void deleteOneEmployeeOfADepartment();
	public void deleteAllEmployeesAndItsDepartment(); 
	public void deleteAllEmployeesOfADepartment();
	public  void AddNewEmployeeToExitingDepartment();

}
