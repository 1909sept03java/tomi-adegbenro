package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDAO;
import com.revature.service.ConnectionService;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee getMyManager(Employee emp) {
		int mgr_Id = emp.getManager();
		Employee empManager = null;
				
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mgr_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			if(rs.next()) {
				int empId  = rs.getInt("EMP_ID");
				String firstName = rs.getString("F_NAME");
				String lastName = rs.getString("L_NAME");
				int manager  = rs.getInt("MGR");
				int mgrRole  = rs.getInt("M_ROLE");
				empManager = new Employee(empId, firstName, lastName, manager, mgrRole);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empManager;
	}

	

}
