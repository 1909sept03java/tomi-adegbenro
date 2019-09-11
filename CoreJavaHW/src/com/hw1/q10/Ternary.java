package com.hw1.q10;

import java.util.Scanner;

public class Ternary {
	
	static int minVal(int a, int b){
		int val = (a < b) ? a :b;
		
		return val;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[2];
		System.out.println("Please enter two (2) numbers:");
		for(int i = 0; i <nums.length; i++) {
			nums[i] = scanner.nextInt();
		}
		//debug
		for(int i = 0; i <nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		int minval = minVal(nums[0], nums[1]);
		System.out.println(minval);
				
		scanner.close();
	}

}
