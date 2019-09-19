package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;
import com.revature.beans.Cave;
import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImpl;

public class  BankMenuConsole {
	
	static BankUser bankUser;
	//BankUserDAO bd = 
		
	public BankMenuConsole(BankUser bankUser) {
		super();
		this.bankUser = bankUser;
	}
	public BankMenuConsole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void displayMenu() {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Options \n"
				+ "View Your Accounts: 1\n"
				+ "Select An Account: 2");
		
		try{
			option= scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Try agian");
			}
			switch(option) {
			case 1: 
				BankUserDAO bd =  new BankUserDAOImpl();
				ArrayList<BankAccount> myBankAccounts = bd.viewMyAccounts(bankUser);
				for (BankAccount ba : myBankAccounts) {
					System.out.println(ba.getAccountId()+","+ba.getAccountUser());
				}
				
			}
	}
	
		
		//return 
		
}
	



