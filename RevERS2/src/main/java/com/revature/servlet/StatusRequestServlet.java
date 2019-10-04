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


public class StatusRequestServlet extends HttpServlet{

	
	private static final long serialVersionUID = 8010355942305074286L;
	
	private RequestService reqService;
	private Request req;
	private ArrayList<Request> reqList;
	private Employee emp;
	
	//Using Object Mapper to convert objects to JSON formmated data
	private ObjectMapper om;
	
	public StatusRequestServlet() {
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
		String idString = req.getParameter("options");
		//resp.getWriter().write("Req value is : "+req+"\n");
		//om.writeValueAsString("idString value is : "+idString);
		try {
			//String idString = req.getParameter("options");
			if (idString != null) {
				int stat = Integer.parseInt(idString);
				//reqList = reqService.getMyRequestByStatus(emp, stat);
				String requestJSON = om.writeValueAsString(reqService.getMyRequestByStatus(emp, stat));//, memberId));
				//requestJSON.toString().substring(1,requestJSON.toString().length()-1);
				session.setAttribute("results", requestJSON);
				//session.setAttribute("results", om.writeValue(reqService.getMyRequestByStatus(emp, stat)));
				//session.setAttribute("results", om.writeValueAsString(requestJSON));
				resp.sendRedirect("Results.html");
				//resp.getWriter().write("Before if: "+stat+"\n"+ "Emp value: "+emp.getFirstName());
				if (!requestJSON.equals("null")) {
					resp.getWriter().write(requestJSON);
				} else {
					//place holder
					resp.sendError(404);
					//resp.getWriter().write("We find ourselves in the land of 404: "+req.getParameter("options"));	
				}
			}else {
				resp.getWriter().write(om.writeValueAsString(reqService.getMyRequests(emp)));
			}
		}catch (Exception e) {
			resp.sendError(404);
			//e.printStackTrace();
		
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
