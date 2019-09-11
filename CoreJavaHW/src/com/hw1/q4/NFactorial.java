package com.hw1.q4;

/* 
 * Q4. Write a program to compute the N Factorial
 */
import java.util.Scanner;

public class NFactorial {
	
	static int nFactorial(int val) {
		//fact = val; //
		
		for(int i=1; i<=val; i++) {
			val = val * i;
		}
		return val;
				
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please nth factorial value:");
		String numString = scanner.nextLine();
		int number = Integer.parseInt(numString); //Using method to convert string to integer
		System.out.println("number is : "+number);
		int fact = nFactorial(number);
		System.out.println("NFactorial is: "+fact);
	}

}

