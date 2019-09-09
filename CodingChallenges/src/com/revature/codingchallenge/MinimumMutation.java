package com.revature.codingchallenge;

import java.lang.String;
import java.util.ArrayList;
import java.lang.StringBuilder;


public class MinimumMutation {
	
	public static void main(String[] args) {
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		//System.out.println(bank[0]);
		
		minMute(start, end, bank);
	}
	
	
	
	
	static Boolean checkvalid(String s) {
		if (s.length() != 8) {
			System.out.println("Not Valid - # of Mutations");
			return false;
		}
		else{
			//MinMute(s);
			return true;
		}
	}
		
	static void minMute(String s, String e, String[] b)	{
		String test = s;
		int count =0;
		int check=0;
		for (int x = 0; x <test.length(); x++) {
			if(test.charAt(x) != e.charAt(x)) {
				count++;
				test = test.substring(0, x)+e.charAt(x)+test.substring(x+1);
				System.out.println(test);
				check = checkBank(test, b);
			}
			else {
				continue;
			}
			System.out.println("Count in MinMute: "+count);
			
		}
		System.out.println("Count in checkBank: "+check);
	}
		
		static int checkBank(String s, String[] b) {
			int count =0;
			System.out.println("First print of s i checkBank: "+s);
			for(String i:b) {
				if (s == i) {
					//debug
					System.out.println("s: "+s);
					count++;
					System.out.println(s+" , "+ count);
				}
				else {
					continue;
				}
			}
			if(count == 0) {
				return -1;
			}
			else {
				return count;
			}
		}
		/*for (String i: b) {
			if(test == i) {
				return 1;
			}
			else {
				for (int x=0; x < test.length(); x++) {
					if(test.charAt(x) == i.charAt(x)) {
						continue;
					}else {
						test= test.substring(0,4)+'X'+test.substring(5);
		
						System.out.println(test);
						
					}
				}
			}
		}*/
		//return 3;
	}


