package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	public int getPagesCount(int pageSize);
	public List<EmployeeDTO> fetchReportData(int pageNo,int pageSize);

}
