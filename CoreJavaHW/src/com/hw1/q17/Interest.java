package com.hw1.q17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interest {
	
	static float interestCalc(float p, float r, float t) {
		
		float interest = p * r* t;
		
		return interest;
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float principal =0;
		float rate = 0;
		float term = 0;
		System.out.println("Please Principal Amount:");
		try {
			principal = scanner.nextFloat();
			System.out.println("Principal is: "+principal);
		}catch(InputMismatchException e) {
			//System.out.println("Please put in an integer");;
		}
		System.out.println("Please Enter Interest Rate (in Percentage):");
		try {
			rate = scanner.nextFloat();
			rate = rate/100;
			System.out.println("Principal is: "+rate);
		}catch(InputMismatchException e) {
			System.out.println("Please put in an integer");
		}
		System.out.println("Please Enter Loan Term (in Years):");
		try {
			term = scanner.nextFloat();
			term = term/12;
			System.out.println("Principal is: "+term);
		}catch(InputMismatchException e) {
			System.out.println("Please put in an integer");
		
		}
		float loanInterest;
		loanInterest = interestCalc(principal, rate, term);
		System.out.println("Simple Interest on the Loan is: "+loanInterest);

	}
}
