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

public class BankAccountDAOImpl implements BankAccountDAO {
	//Account Viewing Function
	public BankAccount viewAccountInfo(BankUser usr, int acId) {
		BankAccount acctInfo = new BankAccount();
		int usrId = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_USER = ? AND ACCOUNT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usrId);
			pstmt.setInt(2, acId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int acctId = rs.getInt("ACCOUNT_ID");
				int acctUser = rs.getInt("ACCOUNT_USER");
				double bal = rs.getDouble("BALANCE");
				double fBalance = rs.getDouble("F_BALANCE");
				acctInfo.setAccountId(acctId);
				acctInfo.setAccountUser(acctUser);
				acctInfo.setBalance(bal);
				acctInfo.setfBalance(fBalance);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return acctInfo;
	}
	
	//Deposit Function
	public BankAccount depositMyAccount(BankUser usr, int acId, double dep) {
		BankAccount acctUpdated = new BankAccount();
		CallableStatement cs = null;
		int usrId = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call SP_DEPOSIT_INTO_ACCOUNT(?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, acId);
			cs.setInt(2, usrId);
			cs.setDouble(3, dep);
			cs.execute();
			//acctUpdated = cs.geto
			//Now get updated Account for display
			String sql2 = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_USER = ? AND ACCOUNT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, usrId);
			pstmt.setInt(2, acId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int acctId = rs.getInt("ACCOUNT_ID");
				int acctUser = rs.getInt("ACCOUNT_USER");
				double bal = rs.getDouble("BALANCE");
				double fBalance = rs.getDouble("F_BALANCE");
				acctUpdated.setAccountId(acctId);
				acctUpdated.setAccountUser(acctUser);
				acctUpdated.setBalance(bal);
				acctUpdated.setfBalance(fBalance);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return acctUpdated;
		
	}
	// Withdraw Function
	public BankAccount withdrawMyAccount(BankUser usr, int acId, double wd) {
		BankAccount acctWithdrawUpdated = new BankAccount();
		CallableStatement cs = null;
		int usrId = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call SP_WITHDRAW_INTO_ACCOUNT(?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, acId);
			cs.setInt(2, usrId);
			cs.setDouble(3, wd);
			cs.execute();
			
			//Now get updated Account for display
			String sql2 = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_USER = ? AND ACCOUNT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, usrId);
			pstmt.setInt(2, acId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int acctId = rs.getInt("ACCOUNT_ID");
				int acctUser = rs.getInt("ACCOUNT_USER");
				double bal = rs.getDouble("BALANCE");
				double fBalance = rs.getDouble("F_BALANCE");
				acctWithdrawUpdated.setAccountId(acctId);
				acctWithdrawUpdated.setAccountUser(acctUser);
				acctWithdrawUpdated.setBalance(bal);
				acctWithdrawUpdated.setfBalance(fBalance);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return acctWithdrawUpdated;
		
	}
	
	public ArrayList<BankAccount> createNewAccount(BankUser usr) {
		List<BankAccount> newAcctList = new ArrayList<BankAccount>();
		BankAccount newAccount = new BankAccount();
		CallableStatement cs = null;
		int usrId = usr.getUserId();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call SP_CREATE_NEW_ACCOUNT(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, usrId);
			cs.execute();
			String sql2 = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_USER = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, usrId);
			ResultSet rs2 = pstmt.executeQuery();
			while(rs2.next()) {
				int acctId = rs2.getInt("ACCOUNT_ID");
				int acctUser = rs2.getInt("ACCOUNT_USER");
				double bal = rs2.getDouble("BALANCE");
				double fBalance = rs2.getDouble("F_BALANCE");
				newAcctList.add(new BankAccount(acctId, acctUser, bal, fBalance));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return (ArrayList<BankAccount>) newAcctList;
	}


}
