package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.service.EmployeeServiceFactory;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageSize=0;
		HttpSession ses=null;
		int pageNo=0;
		EmployeeService service=null;
		List<EmployeeDTO> listDTO=null;
		RequestDispatcher rd=null;
		int pagesCount=0;
		//create or get Session obj
		ses=req.getSession(true);
		//read form data
		if(req.getParameter("size")==null){
		   pageSize=(Integer)ses.getAttribute("pSize");	
		}
		else{
			pageSize=Integer.parseInt(req.getParameter("size"));
			ses.setAttribute("pSize",pageSize);
		}
		if(req.getParameter("pageNo")==null)
			pageNo=1;
		else{
			pageNo=Integer.parseInt(req.getParameter("pageNo"));
		}
		//get Service class object
		service=EmployeeServiceFactory.getInstance();
		//use service
		listDTO=service.fetchReportData(pageNo,pageSize);
		pagesCount=service.getPagesCount(pageSize);
		//keep pagesCount,ListDTO in request scope
		req.setAttribute("reportData",listDTO);
		req.setAttribute("pagesCount",pagesCount);
		//forward req to report.jsp
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req,res);
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
