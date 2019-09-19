package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.dao.BankUserDAO;
import com.revature.util.ConnectionUtil;

public class AccessOperations {
	/*static void userLogin() {
		String usr;
		String pwd;
		Scanner scanUsr = new Scanner();
		Scanner scanPwd = new Scanner();
		System.out.println("Please enter Username:");
		try {
			usr = scanUsr.nextLine();
		}catch (Exception e) {
			System.out.println("Try again");
		}
		System.out.println("Please enter Psssword:");
		try {
			pwd = scanUsr.nextLine();
		}catch (Exception e) {
			System.out.println("Try again");
		}
		
		BankUser loginUser(usr, pwd);
		*/
	
	//public class BankUserDAOImpl implements BankUserDAO{

		public static BankUser loginUser(String usr, String pwd) {
			// TODO Auto-generated method stub
			BankUser b = null;
			//try-with resources....resources included in the try args will be closed at the end of the 
			//block works with  all AutoCloseable resources
			try(Connection conn = ConnectionUtil.getConnection()){
				String sql = "SELECT * FROM BANKUSER WHERE USER_NAME = ? AND PWORD = ?";
				/*
				 * Debug
				 * System.out.println("SQl Statement is : "+sql);
				 */
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, usr);
				pstmt.setString(2, pwd);
				/*
				 * DEBUG
				 * System.out.println("PSMT Statement is : "+pstmt.getResultSetType());
				 */
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int userId = rs.getInt("USER_ID");
					String userName = rs.getString("USER_NAME");
					String password = rs.getString("PWORD");
					int superUser = rs.getInt("SUPER_USER");
					//int maxBears = rs.getInt("MAX_BEARS");
					b = new BankUser(userId, userName, password, superUser);
					/*
					 * DEBUG
					 * System.out.println("user id is : "+userId);
					 */
				}
			}catch (SQLException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			return b;
		}

	

}



