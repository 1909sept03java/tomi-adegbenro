package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.main.BankMenuConsole;

public class Login {
	static void getLoginCredentials() {
		String bankUser=null;
		String password=null;
		Scanner scanner = new Scanner(System.in);
		BankUser b=null;
		System.out.println("Please enter your user name:");
		
		try{
			bankUser = scanner.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Try agian");
			}
		System.out.println("Please enter your password:");
		
		try{
			password = scanner.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Try agian");
			}
		try {
			b = AccessOperations.loginUser(bankUser, password);
			/*
			 * DEbug*/
			 System.out.println(b.getUserId()+" "+b.getPassword()+" "+b.getUserName());
			 
			}catch(NullPointerException e) {
				System.out.println("Please re-enter your credentials: ");
				Login.getLoginCredentials();
			}
			System.out.println("Welcome back "+ b.getUserName() +"!");
			BankMenuConsole bm = new BankMenuConsole(b);
			bm.displayMenu();
			
	}
	
	
	

}
