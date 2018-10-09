package com.nt.delegate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.nt.dao.LibraryMgmtDAO;
import com.nt.dao.LibraryMgmtDAOFactory;
import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.dto.LibraryMembershipDTO;
import com.nt.dto.StudentDTO;
import com.nt.errors.RegistrationProblemException;
import com.nt.errors.RequestedDetailsNotFoundException;
import com.nt.vo.StudentVO;

public class AcademicOperationsBusinessDelegate {
	
	public List<StudentDTO> fetchStudentsWithLibraryMembershipDetails()throws RequestedDetailsNotFoundException{
		LibraryMgmtDAO dao=null;
		List<Student> listStuds=null;
		List<StudentDTO> listStudDTO=new ArrayList();
		try{
		//get DAO
		dao=LibraryMgmtDAOFactory.getInstance();
		//use dAO
		listStuds=dao.getStudentsWithLibraryMembershipDetails();
		//convert List domain objs to List DTO 
		 listStuds.forEach(stud->{
			StudentDTO studDTO=new StudentDTO();
			studDTO.setSid(stud.getSid());
			studDTO.setSname(stud.getSname());
			studDTO.setSadd(stud.getSadd());
			LibraryMembership lib=stud.getLibraryDetails();
			LibraryMembershipDTO libDTO=new LibraryMembershipDTO();
			libDTO.setLid(lib.getLid());
			libDTO.setType(lib.getType());
			libDTO.setDoj(lib.getDoj());
			studDTO.setLibraryDetails(libDTO);
			libDTO.setStudentDetails(studDTO);
			listStudDTO.add(studDTO);
		 });
		}
		catch(HibernateException he){
			throw new RequestedDetailsNotFoundException("Details not found");
		}
		
		return listStudDTO;
	}
	
	
	public String deleteStudentWithLibraryDetails(int sid)throws RequestedDetailsNotFoundException{
		LibraryMgmtDAO dao=null;
		int count=0;
	
		try{
		//get DAO class obj
		dao=LibraryMgmtDAOFactory.getInstance();
		//use dAO
		count=dao.deleteStudentWithLibraryLibraryDetails(sid);
		if(count==0)
			return sid+" student and his Library Details are not deleted";
		else
			return sid+" student and his Library Details are  deleted";
		}
		catch(HibernateException he){
			throw new RequestedDetailsNotFoundException("details not found exception");
		}
	}//method
	
	public String registerStudent(StudentVO vo)throws RegistrationProblemException{
		LibraryMgmtDAO dao=null;
		Student stud=null;
		LibraryMembership lib=null;
		int id=0;
	
		try{
		 //conver VO class obj to domains
		 stud=new Student();
         stud.setSname(vo.getSname());
         stud.setSadd(vo.getSadd());
         lib=new LibraryMembership();
         lib.setType(vo.getLibraryDetails().getType());
         lib.setDoj(new Date());
         stud.setLibraryDetails(lib);
         lib.setStudentDetails(stud);
		//get DAO class obj
		dao=LibraryMgmtDAOFactory.getInstance();
		//use dAO
		id=dao.insertStudent(stud);
		if(id==0)
			return "registration failed";
		else
			return "Registration succeded with-->"+id;
		}//try
		catch(HibernateException he){
			throw new RegistrationProblemException("registrion problem");
		}
	}//method

}
