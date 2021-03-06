package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = -1409891142577013518L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("userId")!= null) {
			//resp.getWriter().write("welcome to your profile "+session.getAttribute("firstname")+" "+session.getAttribute("lastname"));
			//resp.sendRedirect("Test.html");
			//resp.sendRedirect("Test2.html");
			req.getRequestDispatcher("Reimbursements.html").forward(req, resp);
			//resp.sendRedirect(reimbursements);
			
			
		}else {
			resp.sendRedirect("profile");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
