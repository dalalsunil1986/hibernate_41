package com.nt.dao;

import java.util.List;

import com.nt.domain.Employee;

public interface EmployeeDAO {
	public long totalRecordsCount();
	public List<Employee> reportData(int startPos,int pageSize);

}
