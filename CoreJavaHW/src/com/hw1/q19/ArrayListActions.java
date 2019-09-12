package com.hw1.q19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListActions {
	
	static void getEvens(ArrayList<Integer> e) {
		int evenTotal = 0;
		for(int i=0; i < e.size(); i++) {
			if(e.get(i)%2 == 0) {
				evenTotal+=e.get(i);
			}
		}
		System.out.println("Sum of evens is: "+ evenTotal);
	}
	
	static void getOdds(ArrayList<Integer> o) {
		int oddTotal = 0;
		for(int i=0; i < o.size(); i++) {
			if(o.get(i)%2 == 1) {
				oddTotal+=o.get(i);
			}
		}
		System.out.println("Sum of odds is: "+ oddTotal);
	
		
	}

	/*static ArrayList<Integer> getPrime(ArrayList<Integer> p) {
		ArrayList<Integer> primeArray = new ArrayList<Integer>();
		boolean primeBoolean = true;
		for (int i = 1; i < p.size(); i++) {
			int prime = p.get(i);
			primeBoolean = bringPrime(p.get(i));
			if(primeBoolean == true) {
				primeArray.add(prime);
				//System.out.println("Output primeArray: "+primeArray.get(prime));
			}
			//System.out.println("Prime: "+prime);
		}
		return primeArray;
	}
	
	static boolean bringPrime(int num){
		//System.out.println("Entry point num: "+num);
		if (num <=1) {
			return false;
		}
		for(int i=2; i < Math.sqrt(i); i++) {
			if(num % i == 0) {
				System.out.println(num+"mod "+i+" = "+num%i);
				return false;
			}
		}
		return true;
	
	}*/
	
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
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean isPrime = true;
		String primeNumbers = "";
		int prime;
		
		for(int i =1; i<= 10; i++) {
			list.add(i);
		}
		getEvens(list);
		getOdds(list);
		Iterator<Integer> itr = list.iterator();
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
