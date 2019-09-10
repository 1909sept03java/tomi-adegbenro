package com.revature.codingchallenge;

import java.lang.String;
import java.util.ArrayList;
import java.lang.StringBuilder;


public class MinimumMutation {
	
	public static void main(String[] args) {
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		//Check Validity of Start String;
		Boolean check_valid = checkvalid(start);
		if(check_valid == false) {
			int min = -1;
		}
		else {
			int min = minMutation(start, end, bank);
			System.out.println("Minimal Mutation Result: "+min);
		}
		
	}
	
	
	
	//This Method Checks the Validity of a String
	static Boolean checkvalid(String s) {
		if (s.length() != 8) {
			System.out.println("Not Valid - # of Mutations");
			return false;
		}
		else{
			return true;
		}
	}
		
	//This Method Initiates the Iteration to Check for the Minimum # of Mutations
	static int minMutation(String s, String e, String[] b)	{
		/*Debug
		 * System.out.println("Original Start: "+ s);
		 */
		String test = s;
		int mut_count = 0;
		int check=0;
		for (int x = 0; x <test.length(); x++) {
			/*Debug
			 * System.out.println("Start MinMute For Loop");
			 */
			if(test.charAt(x) != e.charAt(x)) {
				mut_count++;
				test = test.substring(0, x)+e.charAt(x)+test.substring(x+1);//Replace char to match End String
				/* Debug
				 * System.out.println(test);
				 */
				check = checkBank(test, b);
			}
			else {
				continue;
			}
			/* Debug 
			System.out.println("Count in MinMutation: "+mut_count);
			*/
		}
		
		/* Debug
		System.out.println("Count in checkBank: "+check);
		*/
		
		if(check == 0) {
			return -1;
		}
		return mut_count;
	}
		
	//This method Checks for End Mutation in Bank
		static int checkBank(String s, String[] b) {
			
			for(String i:b) {
				String temp = s;
				System.out.println("String lookup. Start: "+ temp +" with "+"Bank Entry: "+i);
				if (temp.equals(i)) {
					//debug
					System.out.println("true");
					return 1;
					//System.out.println("s+ , "+ count);
				}
				else {
					System.out.println("false");
					continue;
				}
			}
			return 0;
		}
	}


