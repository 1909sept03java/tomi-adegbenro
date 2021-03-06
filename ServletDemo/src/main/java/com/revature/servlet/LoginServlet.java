package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {

	private AuthenticationService authService = new AuthenticationService();
	private static final long serialVersionUID = -4008501494161108628L;

	//private static final long serialVersionUID = 817105812389880890L;

	/*
	 * Create two methods: - a doGet to handle GET requests for our login page - a
	 * doPost to handle POST requests with credentials
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Session checking way - check whether a session already exists, and 
		//create one if not overloaded version takea boolean parameter, if false returns null
		//if not, session exists matching the incomming request's JSESSIONID token
		HttpSession session = req.getSession();
		//grab credentials from the request - use getParameter from form data
		
		/* Previous examples
		 * String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);*/
		
		Credentials creds = new Credentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		// pass responsibility for performing auth logic to a service
		User u = authService.authenticateUser(creds);
		if (u != null) {
			// they're real 
			session.setAttribute("userId", u.getId());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("problem", null);
			// redirect to their profile
			resp.sendRedirect("profile");
		} else {
			// they're not real
			// resp.getWriter().write("invalid credentials");
			// redirect back to login
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("login");
		}
	}
}
