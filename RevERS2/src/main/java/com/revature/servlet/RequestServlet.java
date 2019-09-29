package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/viewRequests") 
public class RequestServlet extends HttpServlet{

	
	private static final long serialVersionUID = 8070115056439532175L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		//setAccessControlHeaders(resp);
		//re do this to get all information on requests
		if (session != null && session.getAttribute("userId")!= null) {
			req.getRequestDispatcher("Reimbursements.html").forward(req, resp);
		}else {
			resp.sendRedirect("profile");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	//Request Service
	
	//Object Mapper
	
	//Construcutor for Requests

}
