package com.hw1.q8;

import java.util.ArrayList;

public class Palindromes {
	
	static ArrayList<String> returnPalindromes(ArrayList<String> oList) {
		ArrayList<String> palidrome = new ArrayList<String>();
		for(String i:oList) {
			StringBuilder pcheck = new StringBuilder();
			pcheck.append(i);
			//reverse work
			pcheck.reverse();
			//convert to String
			String p = pcheck.toString();
			/*
			 * Debug output
			 * System.out.println("original: "+i+" pcheck: "+pcheck);
			 */
			if(i.equals(p)) {
				
				palidrome.add(p);
			}
				
		}
		return palidrome;
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> originalList = new ArrayList<String>();
		originalList.add("karan");
		originalList.add("madam");
		originalList.add("tom");
		
		//print original list
		System.out.println("Original List");
		System.out.println("----------------");
		for(String i:originalList) {
			System.out.println(i);
		}
		
		ArrayList<String> palindromeList = returnPalindromes(originalList);
		
		//print palindromes list
		System.out.println("Palindrome List");
		System.out.println("----------------");
		for(String i:palindromeList) {
			System.out.println(i);
		}
		
	}

}
