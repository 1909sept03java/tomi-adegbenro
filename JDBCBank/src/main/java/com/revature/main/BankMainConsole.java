package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankMainConsole {
	public static void displayMainMenu() {
		int option=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to JDBC Bank \n"
				+ "Please Enter Menu #: \n"
				+ "User Login: \t 1\n"
				+ "Register: \t 2");
		try{
		option= scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Try again");
			displayMainMenu();
			//scanner.close();
					
		}
		/*System.out.println("Please Enter Menu #: \n"
				+ "User Login: \t 1\n"
				+ "Register: \t 2");*/
		
		switch(option) {
		case 1: 
			Login.getLoginCredentials();
			break;
		case 2:
			Registration.registerCredentials();
			break;
		}
		scanner.close();
	}

}
