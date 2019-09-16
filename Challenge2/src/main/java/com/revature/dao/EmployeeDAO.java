package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void createEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	

}
