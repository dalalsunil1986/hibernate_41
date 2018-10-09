package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectService;
import com.nt.service.ProjectServiceImpl;


//@WebServlet("/controller")
public class MainController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pid=0;
		ProjectService service=null;
		ProjectDTO dto=null;
		RequestDispatcher rd=null;
		
		//read form data
		pid=Integer.parseInt(req.getParameter("pid"));
		//create Service class object
		service=new ProjectServiceImpl();
		//use service
		dto=service.fetchProject(pid);
		//keep result dto in request scope
		req.setAttribute("projDetails",dto);
		//forward request
		rd=req.getRequestDispatcher("/show_project.jsp");
		rd.forward(req,res);
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req, res);
	}//doPost(-,-)
}//class
