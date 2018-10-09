package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.domain.Employee;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public int getPagesCount(int pageSize) {
		EmployeeDAO dao=null;
		long recordsCount=0;
		int pagesCount=0;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//use DAO
		recordsCount=dao.totalRecordsCount();
		pagesCount=(int) (recordsCount/pageSize);
		 if(recordsCount%pageSize!=0)
			 pagesCount++;
		 
		return pagesCount;
	}

	@Override
	public List<EmployeeDTO> fetchReportData(int pageNo, int pageSize) {
		int startPos=0;
		EmployeeDAO dao=null;
		List<Employee> list=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//get start position
		startPos=(pageNo*pageSize)-pageSize;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//use DAO
		list=dao.reportData(startPos, pageSize);
		//convert listDomain objs to ListDTO
		list.forEach(emp->{
			EmployeeDTO empDTO=new EmployeeDTO();
            empDTO.setEid(emp.getEid());
            empDTO.setFirstName(emp.getFirstName());
            empDTO.setLastName(emp.getLastName());
            empDTO.setSalary(emp.getSalary());
            listDTO.add(empDTO);
		});
		return listDTO; 
	}//method
}//class
