package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.BankUser;

public interface SuperUserDAO extends BankUserDAO{
	
	public ArrayList<BankUser> viewUsers();
	public ArrayList<BankUser> deleteUser(int usrId);

}
