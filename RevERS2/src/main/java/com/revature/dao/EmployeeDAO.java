package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;





public interface EmployeeDAO {
	public Employee getMyManager(Employee emp);
	public ArrayList<Employee> getMyTeam (Employee emp);
	public ArrayList<Employee> getMyTeamById(Employee emp, int member);
	//public ArrayList<Request> getRequest(Employee emp, int action);
	
	
}
