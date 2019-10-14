package com.revature.repeat;

import java.util.Scanner;

public class RepeatableString {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter string: \n");
		String repString = scanner.nextLine();
		System.out.println(repString);
		
		System.out.println("Please number of reps: \n");
		int nChars = scanner.nextInt();
		System.out.println(nChars);
		
		long num_strings = nChars/repString.length();
    	System.out.println(num_strings);
    	
    	//remainder 
    	long remainder = nChars%repString.length();
    	
    	long counter1 = 0; // counting a from nChars
    	
    	long counter2 =0; //counting a's from reminder
    	
    	for (int i= 0; i < repString.length(); i++) {
    		if (repString.charAt(i) == 'a') 
    			counter1+= 1;
    	
    		if(repString.charAt(i) == 'a' && i <remainder) 
    			counter2+= 1;
    		
    	}
    	//Total number of a's
    	long total = (counter1 *num_strings) + counter2;
    			
		
		scanner.close();
		
		System.out.println("NUmber of a's in string length of "+nChars+" is "+total);
		
	}

}
