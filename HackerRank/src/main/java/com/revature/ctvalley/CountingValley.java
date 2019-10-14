package com.revature.ctvalley;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValley {

    // Complete the countingValleys function below.
    static int countingValleys(String s) {
    	int counterD = 0;
    	int counterU = 0;
    	int trackValley = 0;
    	int tracking =0;
    	boolean inValley = false;
    	
        if (s.length()%2 ==0 && s.length()<=1000000){
            for(int i=0 ; i<s.length(); i++){
            	
                if(s.charAt(i) == 'D') {
                	counterD +=1;
                	tracking -= 1;
                }
                    
                
                if(s.charAt(i) == 'U') {
                	counterU +=1;
                	tracking += 1;
                }
                
                if(tracking < 0 && inValley == false) {
                	trackValley +=1;
                    inValley = true;
                }
                if(tracking == 0 && inValley == true) {
                	inValley = false;
                }
            }
            if(counterU != counterD) {
            	System.out.println(" Journey does not end at sea level");
            	
            }else {
            	System.out.println("Journey ends at sea level");
            }
        }else{
            System.out.println("Does not met criteria");
        }
        
        return trackValley;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        System.out.println();
    	//int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(s);
        System.out.println("Gary went into "+result+" valley(s)");

        //bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
