package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImpl;
import com.revature.beans.BankUser;
import com.revature.main.AccessOperations;

public class BankConsole {
	public static void main(String[] args) {
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
		
		
	}

}

