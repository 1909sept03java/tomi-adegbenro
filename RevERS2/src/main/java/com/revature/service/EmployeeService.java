package com.revature.service;

import java.util.ArrayList;

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
	
	public ArrayList<Employee> getMyTeam(Employee e){
		return emp.getMyTeam(e);
	}
	
	public ArrayList<Employee> getMyTeamById(Employee e, int m){
		return emp.getMyTeamById(e, m);
	}
	

}
