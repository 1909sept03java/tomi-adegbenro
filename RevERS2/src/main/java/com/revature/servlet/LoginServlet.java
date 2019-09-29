package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;

//@WebServlet("/login") //Using @WebServlet annotation instead of registering/mapping in web.xml

public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = -7037626602588974000L;
	private AuthenticationService authService = new AuthenticationService();
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login2.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	HttpSession session = req.getSession();
	//grab credentials from the request - use getParameter from form data
		Credentials creds = new Credentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		// pass responsibility for performing auth logic to a service
		Employee e = authService.authenticateUser(creds);
		if (e != null) {
			// they're real 
			session.setAttribute("userId", e.getEmpId());
			session.setAttribute("firstname", e.getFirstName());
			session.setAttribute("lastname", e.getLastName());//continue from here
			session.setAttribute("manager", e.getManager());
			session.setAttribute("mgrRole", e.getMgrRole());
			session.setAttribute("problem", null);
			// redirect to their profile
			resp.sendRedirect("profile");
		} else {
		// they're not real
		//resp.getWriter().write(req.getParameter("password")+" are invalid credentials");
		// redirect back to login
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("login");
		}
	}
}
