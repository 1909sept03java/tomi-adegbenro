package com.revature.servlet;

import java.io.IOException;

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

public class ManagerServlet extends HttpServlet{
	
	// this is our service class whose methods we will call
	private EmployeeService empService;
	private Employee emp;
	
	//Using Object Mapper to convert objects to JSON formmated data
	private ObjectMapper om;
	
	public ManagerServlet() {
		empService = new EmployeeService();
		emp = new Employee();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}
	
	//Function returns Manager info in JSON format
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		resp.getWriter().write("the session still is "+session.getAttribute("firstname")+" "+session.getAttribute("lastname")+"\n");
		//resp.getWriter().write("Also, "+session.getAttributeNames()+" , "+ session.getClass());
		
		emp.setEmpId((Integer) session.getAttribute("userId"));
		emp.setFirstName((String) session.getAttribute("firstname"));
		emp.setLastName((String) session.getAttribute("lastname"));
		emp.setManager((Integer) session.getAttribute("manager"));
		emp.setMgrRole((Integer) session.getAttribute("mgrRole"));
		
		String managerJSON = om.writeValueAsString(empService.getMyManager(emp));
		if (!managerJSON.equals("null")) {
			resp.getWriter().write("Manager is "+managerJSON);
		} else {
			resp.sendError(404);
		}
		
		/*// check whether there is an id provided in the query string
		//String idString = req.getParameter("Manager");
		//if (idString != null) {
			// try and find the desired bear
			try {
					emp = om.readValue(req.getReader(), valueType)
				
				
					int id = Integer.parseInt(idString);
				String bearJSON = om.writeValueAsString(bearService.getBearById(id));
				// if ObjectMapper gets a null value, it will be converted to a String "null"
				if (!bearJSON.equals("null")) {
					resp.getWriter().write(bearJSON);
				} else {
					resp.sendError(404);
				}
			} catch (Exception e) {
				resp.sendError(400); // general bad request
			}
		} else {
			// otherwise return all bears
			resp.getWriter().write(om.writeValueAsString(bearService.getBears()));
		}*/
	}


}

