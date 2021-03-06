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
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.service.RequestService;

//@WebServlet("/viewRequests") 
public class RequestServlet extends HttpServlet{

	
	private static final long serialVersionUID = 8070115056439532175L;
	
	private RequestService reqService;
	private Request req;
	private ArrayList<Request> reqList;
	private Employee emp;
	
	//Using Object Mapper to convert objects to JSON formmated data
	private ObjectMapper om;
	
	public RequestServlet() {
		reqService = new RequestService();
		req = new Request();
		reqList = new ArrayList<Request>();
		emp = new Employee();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		emp.setEmpId((Integer) session.getAttribute("userId"));
		emp.setFirstName((String) session.getAttribute("firstname"));
		emp.setLastName((String) session.getAttribute("lastname"));
		emp.setManager((Integer) session.getAttribute("manager"));
		emp.setMgrRole((Integer) session.getAttribute("mgrRole"));
		//Input from webpage
		String idString = req.getParameter("requestId");
		
		try {
			if (idString != null) {
				int id = Integer.parseInt(idString);
				String requestJSON = om.writeValueAsString(reqService.getMyRequestById(emp, id));//, memberId));
				if (!requestJSON.equals("null")) {
					resp.getWriter().write(requestJSON);
				} else {
					//place holder
					resp.sendError(404);
				}
			}else {
				resp.getWriter().write(om.writeValueAsString(reqService.getMyRequests(emp)));
			}
		}catch (Exception e) {
			resp.sendError(404);
		}
		
		
		//not sure yet
		/*if (session != null && session.getAttribute("userId")!= null) {
			resp.sendRedirect("reimbursements");
		}else {
			resp.sendRedirect("profile");
		}*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
