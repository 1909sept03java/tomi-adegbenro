package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.service.RequestService;

@WebServlet("/reqCreate") 
public class ReqCreateServlet extends HttpServlet{

	private static final long serialVersionUID = -3663701327388368209L;
	
	private RequestService reqService;
	private Employee emp;
	
	public ReqCreateServlet() {
		reqService = new RequestService();
		emp = new Employee();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Reimbursements.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		emp.setEmpId((Integer) session.getAttribute("userId"));
		emp.setFirstName((String) session.getAttribute("firstname"));
		emp.setLastName((String) session.getAttribute("lastname"));
		emp.setManager((Integer) session.getAttribute("manager"));
		emp.setMgrRole((Integer) session.getAttribute("mgrRole"));
		
		String title = req.getParameter("reqTitle");
		String summary = req.getParameter("reqSummary");
		float amount = Float.parseFloat(req.getParameter("reqAmount"));
		boolean success = reqService.createRequest(emp, title, summary, amount);
		if (success) {
			resp.sendRedirect("reimbursements");
		} else {
			//place holder
			resp.sendRedirect("reqCreate");
		}
	}

	
	
	

}
