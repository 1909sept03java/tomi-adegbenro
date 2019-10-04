	package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

//@TeamServlet("/myTeam") 
public class TeamServlet extends HttpServlet{

	private static final long serialVersionUID = 1567706607614931927L;
	
	private EmployeeService empService;
	private Employee emp;
	private ArrayList<Employee> teamEmp;
	
	//Using Object Mapper to convert objects to JSON formmated data
	private ObjectMapper om;
	
	public TeamServlet() {
		empService = new EmployeeService();
		emp = new Employee();
		teamEmp = new ArrayList<Employee>();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		// check whether there is an id provided in the query string
		emp.setEmpId((Integer) session.getAttribute("userId"));
		emp.setFirstName((String) session.getAttribute("firstname"));
		emp.setLastName((String) session.getAttribute("lastname"));
		emp.setManager((Integer) session.getAttribute("manager"));
		emp.setMgrRole((Integer) session.getAttribute("mgrRole"));
		//Input from webpage
		String idString = req.getParameter("memberId");
		String teamMemberJSON;
		String teamJSON="";
		
		if(idString == "") {
			idString = null;
		}
		System.out.println("IdString is:"+idString);
		teamJSON = om.writeValueAsString(empService.getMyTeam(emp));
		if (idString != null) {
			try {
				int id = Integer.parseInt(idString);
				teamMemberJSON = om.writeValueAsString(empService.getMyTeamById(emp, id));//, memberId));
				
				
				if (!teamMemberJSON.equals("null")) {
					resp.getWriter().write(om.writeValueAsString(teamMemberJSON));
					session.setAttribute("empResults", teamMemberJSON);
					resp.sendRedirect("Employees.html");
					//resp.getWriter().write("Placeholder for getMyTeamById");
				} else {
					//resp.sendError(404);
					resp.getWriter().write(om.writeValueAsString(empService.getMyTeam(emp)));
					session.setAttribute("empResults", teamJSON);
					resp.sendRedirect("Employees.html");
				}
			}catch (Exception e) {
				e.printStackTrace();
				resp.sendError(404);
			}
		}else {
			session.setAttribute("empResults", teamJSON);
			resp.sendRedirect("Employees.html");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
