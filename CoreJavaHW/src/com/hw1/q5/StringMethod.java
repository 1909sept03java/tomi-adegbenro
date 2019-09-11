package com.hw1.q5;

import java.util.Scanner;

public class StringMethod {
	
	static String stringReturn(String inp, int idx) {
		String subset = inp.substring(0, idx);
		return subset;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string value: ");
		String input = scanner.nextLine();
		
		System.out.println("Enter index value: ");
		int index = scanner.nextInt();
		String r = stringReturn(input, index);
		System.out.println(r);
		//System.out.println(" Subset string is: "+r);
		scanner.close();
	}

}
