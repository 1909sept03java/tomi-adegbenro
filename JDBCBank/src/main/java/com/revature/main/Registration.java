package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.main.BankMenuConsole;

public class Registration {
	static void registerCredentials() {
		String newUser=null;
		String password=null;
		Scanner scanner = new Scanner(System.in);
		double b;
		System.out.println("Please enter preferred username:");
		
		try{
			newUser = scanner.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Try again");
			}
		System.out.println("Please enter your preferred password:");
		
		try{
			password = scanner.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Try agian");
			}
		try {
			b = AccessOperations.registerUser(newUser, password); 
			/*
			 * DEbug
			 if(b==0) {
				 System.out.println("B is not null");
			 }else {
				 System.out.println("B is empty");
			 }*/
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("You can now Login");
			BankMainConsole.displayMainMenu();
	}
	

}
