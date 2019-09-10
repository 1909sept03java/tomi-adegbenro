package com.hw1.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Reverse a string without using a temporary variable. 
 * Do NOT use reverse() in the 
 * StringBuffer or the StringBuilder APIs
 */

public class ReverseString {
	static void reverseString(String s) {
		
		/*Debug Code
		for(int i = 0; i < s.length(); i++) {
			/* Debug code
			 System.out.println(s.charAt(i));
		}*/
		
		String ch ="";
		for(int i=s.length()-1; i>=0; i--) {
			ch = ch+ s.charAt(i);
			//count++
			
		}
		
		System.out.println("Reverse String is:" + ch);
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string value: ");
		String input = scanner.nextLine();
		reverseString(input);
	}

}

