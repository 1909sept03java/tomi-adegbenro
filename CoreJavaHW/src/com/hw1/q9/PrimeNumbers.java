package com.hw1.q9;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimeNumbers {
	
	static boolean getPrimes(int num){
		
		if (num <=1) {
			return false;
		}
		for(int i=2; i < Math.sqrt(i); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
		
		
	public static void main(String[] args) {
		boolean isPrime = true;
		String primeNumbers = "";
		int prime;
		ArrayList<Integer> olist =new ArrayList<Integer>();
		
		for(int i =1; i<= 100; i++) {
			olist.add(i);
		}
		
		Iterator<Integer> itr = olist.iterator();
		while(itr.hasNext()) {
			
			prime = itr.next();
			isPrime = getPrimes(itr.next());
			if(isPrime == true) {
				primeNumbers = primeNumbers+" "+prime;
			}
		}
		System.out.println("Prime Numbers: "+" "+primeNumbers);
	}

}
