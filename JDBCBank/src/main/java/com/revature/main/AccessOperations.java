package com.revature.main;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.dao.BankUserDAO;
import com.revature.util.ConnectionUtil;

public class AccessOperations {

		public static BankUser loginUser(String usr, String pwd) {
			BankUser b = null;
			try(Connection conn = ConnectionUtil.getConnection()){
				String sql = "SELECT * FROM BANKUSER WHERE USER_NAME = ? AND PASS = ?";
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
					String password = rs.getString("PASS");
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
		
		public static double registerUser(String usr, String pwd) {
			//BankUser b = null;
			double userCheck=0;
			BankUser b = new BankUser();
			CallableStatement cs = null;
			try(Connection conn = ConnectionUtil.getConnection()){
				String sql = "{call SP_CREATE_NEW_USER(?,?,?)}";
				cs = conn.prepareCall(sql);
				cs.setString(1, usr);
				cs.setString(2, pwd);
				cs.registerOutParameter(3,java.sql.Types.DECIMAL);
				cs.execute();
				userCheck = cs.getDouble(3);
				if(userCheck == 0) {
					System.out.println(" Congratulations!");
				}
				//This part of the code needs some work 
				/*
				String sql2 = "SELECT * FROM BANKUSER WHERE USER_NAME = ? AND PASS = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, usr);
				pstmt.setString(2, pwd);
				
				ResultSet rs2 = pstmt.executeQuery();
				if(rs2.next()) {
					System.out.println("RS RESULTS "+rs2.getInt("SUPER_USER"));
					int usrId = rs2.getInt("USER_ID");
					String usrName = rs2.getNString("USER_USER");
					//Object usrName = rs2.getObject("USER_USER");
					String passwd = rs2.getNString("PASS");
					//Object passwd = rs2.getObject("PASS");
					int sUser = rs2.getInt("SUPER_USER");
					//b = new BankUser(usrId, usrName, passwd, sUser);
					//String uName = usrName.toString();
					//String pWord = passwd.toString();
					b.setUserId(usrId);
					b.setUserName(usrName);
					//b.setUserName(uName);
					b.setPassword(passwd);
					//b.setPassword(pWord);
					b.setSuperUser(sUser);
					//debug
					System.out.println("Got back:"+usrId+" "+usrName+" "+passwd);
				}*/
			}catch (SQLException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}
			
			return userCheck;
		}
				
}



