package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.beans.Employee;
import com.revature.beans.Request;

@WebServlet("/empResults") 
public class EmpResultsServlet extends HttpServlet{
	
	private static final long serialVersionUID = -5169946983056958281L;
	
private ObjectMapper om;
	
	public EmpResultsServlet() {
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			String res_conv = session.getAttribute("empResults").toString();
			System.out.println(res_conv);
			ArrayList<Employee> results = om.readValue(res_conv, new TypeReference<ArrayList<Employee>>() {});
			System.out.println(results);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(results));
		}catch (Exception e) {
			e.printStackTrace();
			//resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
