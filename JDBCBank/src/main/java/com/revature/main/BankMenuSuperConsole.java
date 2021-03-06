package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.BankAccountDAOImpl;
import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImpl;
import com.revature.dao.SuperUserDAO;
import com.revature.dao.SuperUserDAOImpl;

public class BankMenuSuperConsole {
	
	static BankUser bankUser;

	public BankMenuSuperConsole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankMenuSuperConsole(BankUser bankUser) {
		super();
		this.bankUser = bankUser;
	}
	
	public static void displaySuperMenu() {
		int option = 0;
		SuperUserDAO sd =  new SuperUserDAOImpl();
		BankAccountDAO ad = new BankAccountDAOImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Options \n"
				+ "View Accounts: \t \t 1\n"
				+ "Delete An Account: \t 2\n"
				+ "Logout \t \t \t 3");
		
		
		try{
			option= scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Try agian: \n"
						+ "");
			}
		switch(option) {
		case 1:
			ArrayList<BankUser> bankUsers = sd.viewUsers();
			for (BankUser bu : bankUsers) {
				System.out.println("User Id: "+bu.getUserId()+", User Name "+bu.getUserName()+".\n");
			}
			break;
		case 2:
			
			Scanner acctScanner = new Scanner(System.in);
			System.out.println("Please Enter Account id to delete: \n");
			try {
				int usrId = acctScanner.nextInt();
				ArrayList<BankUser> updatedUsers = sd.deleteUser(usrId);
				for (BankUser ua :updatedUsers) {
					System.out.println("User Id: "+ua.getUserId()+", User Name "+ua.getUserName()+".\n");
				}
			}catch(InputMismatchException e) {
					System.out.println("Try again: \n"
							+ "");
			}
			break;
		case 3:
			System.out.println("You are now logged Out \n");
			BankMainConsole.displayMainMenu();
			
			
		}
			
			/*switch(option) {
			case 1: 
				System.out.println("List of Accounts for "+bankUser.getUserName());
				//BankUserDAO bd =  new BankUserDAOImpl();
				ArrayList<BankAccount> myBankAccounts = bd.viewMyAccounts(bankUser);
				for (BankAccount ba : myBankAccounts) {
					System.out.println("Account Number: "+ba.getAccountId()+", Account Balance: "+ba.getBalance()+".\n");
				}
				break;
			case 2:
				Scanner acctScanner = new Scanner(System.in);
				System.out.println("Please Enter Account id: \n");
				try {
					int acctId = acctScanner.nextInt();
					BankAccount ba = ad.viewAccountInfo(bankUser, acctId);
					System.out.println("Account Number: "+ba.getAccountId()+", Account Balance: "+ba.getBalance()+", Former Balance: "+ba.getfBalance()+".\n");
				}catch(InputMismatchException e) {
					System.out.println("Try again: \n"
							+ "");
				}
				acctScanner.reset();
				break;
			case 3:
				Scanner depostScanner = new Scanner(System.in);
				Scanner acctUpdateScanner = new Scanner(System.in);
				System.out.println("Please Enter Amount to Deposit: \n");
				try {
					double dep = depostScanner.nextDouble();
					System.out.println("Please Bank Account Number: \n");
					int acctId = acctUpdateScanner.nextInt();
					BankAccount ua = ad.depositMyAccount(bankUser,acctId, dep);
					System.out.println("Account Number: "+ua.getAccountId()+", Account Balance: "+ua.getBalance()+", Former Balance: "+ua.getfBalance()+".\n");
				}catch(InputMismatchException e) {
					System.out.println("Try again: \n"
							+ "");
				}
				break;
			case 4:
				Scanner withdrawScanner = new Scanner(System.in);
				Scanner acctWithdrawUpdateScanner = new Scanner(System.in);
				System.out.println("Please Enter Amount to Deposit: \n");
				try {
					double wd = withdrawScanner.nextDouble();
					System.out.println("Please Bank Account Number: \n");
					int acctId = acctWithdrawUpdateScanner.nextInt();
					BankAccount uwa = ad.withdrawMyAccount(bankUser,acctId, wd);
					System.out.println("Account Number: "+uwa.getAccountId()+", Account Balance: "+uwa.getBalance()+", Former Balance: "+uwa.getfBalance()+".\n");
				}catch(InputMismatchException e) {
					System.out.println("Try again: \n"
							+ "");
				}
				break;
			case 5:
				ArrayList<BankAccount> myUpdatedBankAccounts = ad.createNewAccount(bankUser);
				for (BankAccount na : myUpdatedBankAccounts) {
					System.out.println("Account Number: "+na.getAccountId()+", Account Balance: "+na.getBalance()+".\n");
				}
				break;
			case 6:
				Scanner deleteAcctScanner = new Scanner(System.in);
				System.out.println("Please Enter Account # to Delete: \n");
				try {
					int acctId = deleteAcctScanner.nextInt();
					ArrayList<BankAccount> myAfterDeleteBankAccounts = bd.deleteAccount(bankUser,acctId);
					for (BankAccount da : myAfterDeleteBankAccounts) {
						System.out.println("Account Number: "+da.getAccountId()+", Account Balance: "+da.getBalance()+".\n");
					}
				}catch(InputMismatchException e) {
					System.out.println("Try again: \n"
							+ "");
				}
				break;
			case 7:
				System.out.println("Thank you for visiting "+bankUser.getUserName()+
						"\n See you next time!\n");
				BankMainConsole.displayMainMenu();
				
				
			}*/
			displaySuperMenu();
	}
		
}
	
	
	


