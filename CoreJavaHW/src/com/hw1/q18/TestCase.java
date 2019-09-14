package com.hw1.q18;

import java.lang.Character.*;
import java.util.Scanner;

public class TestCase implements ConvertCase, ConvertIntegerPlus{
	
	String test;
	static String input;
	static String numInput;
	
	@Override
	public boolean checkUpperCase(String s) {
		char ch;
		for(int i=0; i< s.length(); i++) {
			ch = s.charAt(i);
			if(Character.isUpperCase(ch) == true) {
				return true;
			}
				
		}
		return false;
	}
	
	@Override
	public boolean checkLowerCase(String s) {
		char ch;
		for(int i=0; i< s.length(); i++) {
			ch = s.charAt(i);
			if(Character.isLowerCase(ch) == true) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	//public void convertIntegerPlus(String s) {
	//}

	public void convertIntegerPlus(String s) {
		int num = Integer.parseInt(s);
		num = num+10;
		System.out.println("The Number function result is : "+num);
		// TODO Auto-generated method stub
	}
	@Override
	public String convertLowerCase(String s) {
		String conv = s.toLowerCase();
		return conv;
	}
	@Override
	public String convertUpperCase(String s) {
		String conv = s.toUpperCase();
		return conv;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string to check for upper case: ");
		//String upper = scanner.nextLine();
		TestCase testString = new TestCase();
		TestCase.input = scanner.nextLine();
		if (testString.checkLowerCase(input) == true) {
			testString.test = testString.convertUpperCase(input);
		}
		System.out.println("Upper Case Conversion: "+testString.test);
		
		System.out.println("Enter the number (n): ");
		TestCase.numInput = scanner.nextLine();
		testString.convertIntegerPlus(numInput);
		scanner.close();
	}
	
}

