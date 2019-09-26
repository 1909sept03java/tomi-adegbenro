package com.revature.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class AuthenticationService {
	
	// if credentials are not recognized, return null
	// if they are, return user associated with them
	/*public Employee authenticateUser(Credentials creds) {
		Employee e = null;
		
		/*if (creds.getUsername().equals("merlin") && creds.getPassword().equals("cat")) {
			u = new User(6, "Merlin", "Higgins");
		}
		return u;
		
	}*/
	
	//trying what i did before
	public static Employee authenticateUser(Credentials creds) {
		Employee emp = null;
		try(Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT EMPLOYEE.EMP_ID, EMPLOYEE.F_NAME, EMPLOYEE.L_NAME, EMPLOYEE.MGR, EMPLOYEE.M_ROLE FROM EMPLOYEE INNER JOIN CREDENTIALS ON EMPLOYEE.EMP_ID = CREDENTIALS.EMP_NUM WHERE CREDENTIALS.UNAME = ? AND CREDENTIALS.PASS = ?";
			/*
			 * Debug
			 * System.out.println("SQl Statement is : "+sql);
			 */
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, creds.getUsername());
			pstmt.setString(2, creds.getPassword());
			/*
			 * DEBUG
			 * System.out.println("PSMT Statement is : "+pstmt.getResultSetType());
			 */
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String firstName = rs.getString("F_NAME");
				String lastName = rs.getString("L_NAME");
				int manager = rs.getInt("MGR");
				int mgrRole = rs.getInt("M_ROLE");
				emp = new Employee(empId, firstName, lastName, manager, mgrRole);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return emp;
	}

}
