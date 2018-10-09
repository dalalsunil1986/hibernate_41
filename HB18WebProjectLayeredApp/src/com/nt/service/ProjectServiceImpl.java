package com.nt.service;

import com.nt.dao.ProjectDAO;
import com.nt.dao.ProjectDAOImpl;
import com.nt.domain.Project;
import com.nt.dto.ProjectDTO;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public ProjectDTO fetchProject(int pid) {
		ProjectDAO dao=null;
		Project proj=null;
		ProjectDTO dto=null;
		//use DAO
		dao=new ProjectDAOImpl();
		proj=dao.getProject(pid);
		//convert Domain class obj to DTO class obj
		if(proj!=null){
		dto=new ProjectDTO();
		dto.setProjId(proj.getProjId());
		dto.setProjName(proj.getProjName());
		dto.setTeamSize(proj.getTeamSize());
		dto.setPeriod(proj.getPeriod());
		}
		
		return dto;
	}//method

}
