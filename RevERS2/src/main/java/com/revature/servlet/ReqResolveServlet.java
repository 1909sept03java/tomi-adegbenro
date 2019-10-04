package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.service.RequestService;

@WebServlet("/reqResolve") 
public class ReqResolveServlet extends HttpServlet{

	private static final long serialVersionUID = 3660467274943392328L;
	
	private RequestService reqService;
	private Employee emp;
	
	public ReqResolveServlet() {
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
		
		int req_Id = Integer.parseInt(req.getParameter("reqId"));
		int stat = Integer.parseInt(req.getParameter("resOptions"));;
		boolean success = reqService.resolveRequest(emp, req_Id, stat);
		if (success) {
			resp.sendRedirect("reimbursements");
		} else {
			//place holder
			resp.sendRedirect("reqResolve");
		}
	}
	
	
	

}
