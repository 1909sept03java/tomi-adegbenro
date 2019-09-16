package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImplementation implements EmployeeDAO{

	public List<Employee> getEmployees(){
		List<Employee> el = new ArrayList<>();
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEES";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("EMP_FIRSTNAME");
				String lastName = rs.getString("EMP_LASTNAME");
				el.add(new Employee(employeeId, firstName, lastName));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return el;
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}
	
	

}
