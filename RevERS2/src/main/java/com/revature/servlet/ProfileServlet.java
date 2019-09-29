package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/profile") 

public class ProfileServlet extends HttpServlet{

	
	private static final long serialVersionUID = 8343002811379165553L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("userId")!= null) {
			//resp.getWriter().write("welcome to your profile "+session.getAttribute("firstname")+" "+session.getAttribute("lastname"));
			//resp.sendRedirect("Test.html");
			//resp.sendRedirect("Test2.html");
			req.getRequestDispatcher("Profile.html").forward(req, resp);
			
		}else {
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

	

}
