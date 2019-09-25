package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Credentials;

public class LoginServlet extends HttpServlet {

	
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
		//grab credentials from the request - use getParameter from form data
		/*String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);*/
		
		Credentials creds = new Credentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
	}
}