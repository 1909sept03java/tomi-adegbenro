package com.revature.beans;

import com.revature.dao.BankUserDAO;

public class BankUser {
	
	private int userId;
	private String userName;
	private String password;
	private int superUser;
	//private boolean registered;
	//private boolean logOn;
	
	
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	
	public int getSuperUser() {
		return superUser;
	}

	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}

	public BankUser(int userId, String userName, String password, int superUser) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.superUser = superUser;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
