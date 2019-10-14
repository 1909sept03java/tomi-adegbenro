package com.revature.repeat;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.revature.repeat.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {	
    	
	//first determine number of repeated strings to consider
	long num_strings = n/s.length();
	System.out.println(num_strings);
	
	// deternmine the remainder characters 
	long remainder = n%s.length();
	
	long counter1 = 0; // counting a from nChars
	
	long counter2 =0; //counting a's from reminder
	
	for (int i= 0; i < s.length(); i++) {
		if (s.charAt(i) == 'a') 
			counter1+= 1;
	
		if(s.charAt(i) == 'a' && i <remainder) 
			counter2+= 1;
		
	}
	//Total number of a's
	long total = (counter1 *num_strings) + counter2;
    	
    return total;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

