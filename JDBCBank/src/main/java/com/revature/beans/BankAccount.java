package com.revature.beans;

import com.revature.beans.BankUser;

public class BankAccount {
	
	private int accountId;
	private int accountUser;
	double balance;
	double fBalance;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int accountId, int accountUser) {
		super();
		this.accountId = accountId;
		this.accountUser = accountUser;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getAccountUser() {
		return accountUser;
	}
	public void setAcctOwner(int accountUser) {
		this.accountUser = accountUser;
	}
	public BankAccount(int accountId, int accountUser, double balance, double fBalance) {
		super();
		this.accountId = accountId;
		this.accountUser = accountUser;
		this.balance = balance;
		this.fBalance = fBalance;
	}
	
	
	
	

}
