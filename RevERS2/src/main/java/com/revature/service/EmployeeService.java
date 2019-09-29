package com.revature.service;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeService {
	
	private EmployeeDAO emp = new EmployeeDAOImpl();

	public EmployeeService() {
		super();
	}
	
	public Employee getMyManager(Employee e) {
		return emp.getMyManager(e);
	}
	
	

}
