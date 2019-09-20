package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;

public interface BankAccountDAO {
	
	public BankAccount viewAccountInfo(BankUser usr, int acctId);
	public BankAccount depositMyAccount(BankUser usr, int acctId, double dep);
	public BankAccount withdrawMyAccount(BankUser usr, int acctId, double wd);
	public ArrayList<BankAccount> createNewAccount(BankUser usr);

}
