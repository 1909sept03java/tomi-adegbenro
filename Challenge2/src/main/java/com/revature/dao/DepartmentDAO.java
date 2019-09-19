package com.revature.dao;

import java.util.List;

import com.revature.beans.Department;

public interface DepartmentDAO {
	public List<Department> getDepartments();
	public List<Department> getDeptAvgSalary(int deptId);
	public Department getDepartment(int id);
	public void createDepartment(Department dept);
	public void updateDepartment(Department dept);
	public void deleteEmployee(Department dept);

}
