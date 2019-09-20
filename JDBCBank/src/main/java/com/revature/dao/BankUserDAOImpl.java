package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;
import com.revature.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO{
	
	public ArrayList<BankAccount> viewMyAccounts(BankUser usr){
		List<BankAccount> acctList = new ArrayList<BankAccount>();
		int id = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_USER = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int acctId = rs.getInt("ACCOUNT_ID");
				int acctUser = rs.getInt("ACCOUNT_USER");
				double bal = rs.getDouble("BALANCE");
				double fBalance = rs.getDouble("F_BALANCE");
				acctList.add(new BankAccount(acctId, acctUser, bal, fBalance));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return (ArrayList<BankAccount>) acctList;
				
	}
	
	public ArrayList<BankAccount> deleteAccount(BankUser usr, int actId){
		List<BankAccount> updatedAcctList = new ArrayList<BankAccount>();
		//BankAccount newAccount = new BankAccount();
		CallableStatement cs = null;
		int usrId = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call SP_DELETE_MY_ACCOUNT(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, usrId);
			cs.setInt(2, actId);
			cs.execute();
			String sql2 = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_USER = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, usrId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int acctId = rs.getInt("ACCOUNT_ID");
				int acctUser = rs.getInt("ACCOUNT_USER");
				double bal = rs.getDouble("BALANCE");
				double fBalance = rs.getDouble("F_BALANCE");
				updatedAcctList.add(new BankAccount(acctId, acctUser, bal, fBalance));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return (ArrayList<BankAccount>) updatedAcctList;
	}

	/*public BankUser loginUser(String usr, String pwd) {
		// TODO Auto-generated method stub
		BankUser b = null;
		//try-with resources....resources included in the try args will be closed at the end of the 
		//block works with  all AutoCloseable resources
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BANK WHERE U_NAMEID = ? AND U_PASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String password = rs.getString("PWORD");
				int superUser = rs.getInt("SUPER_USER");
				//int maxBears = rs.getInt("MAX_BEARS");
				b = new BankUser(userId, userName, password, superUser);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return b;
	}*/
	
	

}
