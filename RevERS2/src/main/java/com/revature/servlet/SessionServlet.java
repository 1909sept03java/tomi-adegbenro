package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

@WebServlet("/session") 
public class SessionServlet extends HttpServlet{

	private static final long serialVersionUID = -1319793763433572026L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		try {
			int empId = Integer.parseInt(session.getAttribute("userId").toString());
			String firstname = session.getAttribute("firstname").toString();
			String lastname = session.getAttribute("lastname").toString();
			int manager = Integer.parseInt(session.getAttribute("manager").toString());
			int mgrRole = Integer.parseInt(session.getAttribute("mgrRole").toString());
			Employee emp = new Employee(empId, firstname, lastname, manager, mgrRole);
			//Integer six = 6;
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(emp));// + (new ObjectMapper()).writeValueAsString(six));
		}catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
