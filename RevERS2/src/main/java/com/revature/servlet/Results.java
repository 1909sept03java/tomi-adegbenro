package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/results") 
public class Results extends HttpServlet{

	
	private static final long serialVersionUID = 7328785552388041662L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		try {
			String results = session.getAttribute("results").toString();
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(results));
		}catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
