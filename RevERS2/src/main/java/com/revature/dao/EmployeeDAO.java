package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;





public interface EmployeeDAO {
	public Employee getMyManager(Employee emp);
	//public ArrayList<Request> getRequest(Employee emp, int action);
	
	
}
