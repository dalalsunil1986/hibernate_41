package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.delegate.AcademicOperationsBusinessDelegate;
import com.nt.dto.StudentDTO;
import com.nt.errors.RegistrationProblemException;
import com.nt.errors.RequestedDetailsNotFoundException;
import com.nt.vo.LibraryMembershipVO;
import com.nt.vo.StudentVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	AcademicOperationsBusinessDelegate delegate = null;

	@Override
	public void init() throws ServletException {
		delegate = new AcademicOperationsBusinessDelegate();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String linkType = null;
		List<StudentDTO> listStudDTO = null;
		RequestDispatcher rd = null;
		String deleteMsg=null;
		StudentVO studVO=null;
		LibraryMembershipVO libVO=null;
		String insertMsg=null;
		// get link type
		linkType = req.getParameter("link");
		if (linkType.equalsIgnoreCase("home")) {
			try {
				//invoke business method businessDelegate
				listStudDTO = delegate.fetchStudentsWithLibraryMembershipDetails();
				//keep result in request scope
				req.setAttribute("reportDetails",listStudDTO);
				//froward request to show_details.jsp
				rd=req.getRequestDispatcher("/show_details.jsp");
				rd.forward(req, res);
			} catch (RequestedDetailsNotFoundException rdnfe) {
				req.setAttribute("errMsg", rdnfe.getMessage());
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, res);
			}

		}//if
		else if(linkType.equalsIgnoreCase("delete2")){
			
			try{
			   //invoke b.methods of BusinessDelegate
				deleteMsg=delegate.deleteStudentWithLibraryDetails(Integer.parseInt(req.getParameter("sno")));
				listStudDTO = delegate.fetchStudentsWithLibraryMembershipDetails();
				//keep results in request scope
				req.setAttribute("reportDetails",listStudDTO);
				req.setAttribute("msg",deleteMsg);
				//forward control to show_details.jsp
				rd=req.getRequestDispatcher("/show_details.jsp");
				rd.forward(req,res);
			}//try
			catch(RequestedDetailsNotFoundException rdnfe){
				rd=req.getRequestDispatcher("/error.jsp");
				req.setAttribute("errMsg", rdnfe.getMessage());
				rd.forward(req,res);
			}
		}
		else if(linkType.equalsIgnoreCase("insert")){
			//create VO class objs
			studVO=new StudentVO();
			studVO.setSname(req.getParameter("name"));
			studVO.setSadd(req.getParameter("address"));
			libVO=new LibraryMembershipVO();
			libVO.setType(req.getParameter("type"));
			studVO.setLibraryDetails(libVO);
			libVO.setStudentDetails(studVO);
			//use delegate
			try{
				//invoke delegate b.methods
			 insertMsg=delegate.registerStudent(studVO);
			 listStudDTO = delegate.fetchStudentsWithLibraryMembershipDetails();
				//keep results in request scope
				req.setAttribute("reportDetails",listStudDTO);
				req.setAttribute("msg",insertMsg);
				//forward control to show_details.jsp
				rd=req.getRequestDispatcher("/show_details.jsp");
				rd.forward(req,res);
			}//try
			catch(RequestedDetailsNotFoundException rdnfe){
				rd=req.getRequestDispatcher("/error.jsp");
				req.setAttribute("errMsg", rdnfe.getMessage());
				rd.forward(req,res);
			}
			catch(RegistrationProblemException rpe){
				rd=req.getRequestDispatcher("/error.jsp");
				req.setAttribute("errMsg", rpe.getMessage());
				rd.forward(req,res);
			}
			
		}

	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}

	@Override
	public void destroy() {
		delegate = null;
	}

}//class
