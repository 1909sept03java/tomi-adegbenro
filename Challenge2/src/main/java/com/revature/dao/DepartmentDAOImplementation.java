package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class DepartmentDAOImplementation implements DepartmentDAO{

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getDeptAvgSalary(int deptId) {
		// TODO Auto-generated method stub
		List<Department> dl = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
		return null;
	}

	@Override
	public Department getDepartment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDepartment(Department dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Department dept) {
		// TODO Auto-generated method stub
		
	}
	
	

}
