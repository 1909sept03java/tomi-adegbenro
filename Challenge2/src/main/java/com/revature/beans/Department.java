 package com.revature.beans;

public class Department {
	int department_Id;
	String departmentName;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int department_Id, String departmentName) {
		super();
		this.department_Id = department_Id;
		this.departmentName = departmentName;
	}
	public int getDepartment_Id() {
		return department_Id;
	}
	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	

}
