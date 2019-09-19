package com.revature.main;

import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImpl;
import com.revature.beans.BankUser;
import com.revature.main.AccessOperations;
//import com.revature.beans.Account;

public class TestDrive {
	public static void main(String[] args) throws NullPointerException{
		String user = "badegbenro";
		String pwd = "p4ss";
		BankUser b = AccessOperations.loginUser(user, pwd);
		System.out.println(b.getUserId()+" "+b.getPassword()+" "+b.getUserName());
		
	}

}
