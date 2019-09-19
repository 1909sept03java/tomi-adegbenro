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
				+ "Please enter: \n"
				+ "Login: 1\n"
				+ "Register: 2");
		try{
		option= scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Try agian");
		}
		switch(option) {
		case 1: 
			Login.getLoginCredentials();
		}
		
	}

}

