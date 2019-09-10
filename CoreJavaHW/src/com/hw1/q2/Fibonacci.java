package com.hw1.q2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0
 */

public class Fibonacci {
	
	static ArrayList<Integer> FibSeries(int n) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int temp = 0;
		int num1 =0, num2=1, sum;
		if (n==0) {
			nums.add(num1);
			//return num1;
			return nums;
		}
		else {
			for (int i = 2; i<= n; i++) {
				sum = num1 + num2;
				num1 = num2;
				num2 = sum;
				nums.add(sum);
			}
			//return num2;
			return nums;
		}
		
	}
	
	static int FibNValue (int n) { //Recursion Method
	ArrayList<Integer> nums = new ArrayList<Integer>();
	int temp = 0;
	if (n <=1) {
		return n;
	}
	else {
		temp = FibNValue(n-1) + FibNValue(n-2);
	}
	
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number (n) for nth number in Fibonacci Series: ");
		String numString = scanner.nextLine();
		int number = Integer.parseInt(numString); //Using method to convert string to integer
		
		//Print Fibonnaci series values
		ArrayList<Integer> fib = FibSeries(number);
		System.out.println("Fibonacci Series values are: "+ fib);
		
		//Print nth value of Fibonnaci Series using Recursion Method
		int fibN = FibNValue(number);
		System.out.println("Fibonacci Series Nth values is: "+ fibN);
	}
}


