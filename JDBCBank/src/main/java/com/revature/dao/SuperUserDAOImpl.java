package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;
import com.revature.util.ConnectionUtil;

public class SuperUserDAOImpl implements SuperUserDAO{
	
	public ArrayList<BankUser> viewUsers(){
		List<BankUser> UsersList = new ArrayList<BankUser>();
		CallableStatement cs = null;
		//int usrId = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql2 = "SELECT * FROM BANKUSER";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			//pstmt.setInt(1, usrId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String pass = rs.getString("PASS");
				int sUser = rs.getInt("SUPER_USER");
				UsersList.add(new BankUser(userId, userName, pass, sUser));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return (ArrayList<BankUser>) UsersList;
	}
	public ArrayList<BankUser> deleteUser(int usrId){
		List<BankUser> updatedUserList = new ArrayList<BankUser>();
		CallableStatement cs = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call SP_DELETE_USER(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, usrId);
			cs.execute();
			String sql2 = "SELECT * FROM BANKUSER";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String pass = rs.getString("PASS");
				int sUser = rs.getInt("SUPER_USER");
				updatedUserList.add(new BankUser(userId, userName, pass, sUser));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return (ArrayList<BankUser>) updatedUserList;
	}
	@Override
	public ArrayList<BankAccount> viewMyAccounts(BankUser usr) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<BankAccount> deleteAccount(BankUser usr, int acctId) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<BankUser> viewAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
