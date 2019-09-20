package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;

public interface BankUserDAO {
	
	public ArrayList<BankAccount> viewMyAccounts(BankUser usr);
	public ArrayList<BankAccount> deleteAccount(BankUser usr, int acctId);
	//public BankUser loginUser(String usr, String pwd);
	//public List<User> getUsers();
	//public User getUser(int userId);
	//public void createUser(BankUser usr);
	//public void updateUser(BankUser usr);
	//public void deleteUser(User usr);
	//public void createAcct(Account acct);
	//public void depositToMyAccount();
	//public void withdrawFromMyAccount();

}
