package com.revature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	boolean isMagicsquare (int [][]s) {
		int mc = (s.length*(((s.length*s.length))+1)/2);
		
		System.out.println("magic square is: "+mc);
		int initRowSum =0;
		int diagSum = 0;
		// getting initial to row sum
		for(int j = 0; j <s.length; ++j) {
			initRowSum += s[0][j];
		}
		
		//check if sum of other rows matches initRowSum
		for (int i= 1; i <=s.length; ++i) {
			int temp=0;
			for (int j=0; j<s.length; ++j) {
				temp = temp + s[i][j];
			}
			if(temp != initRowSum)
				return false;
		}
		//check if sum of columns matches initRowSum
		for (int j= 0; j <s.length; ++j) {
			int temp=0;
			for (int i=0; j<s.length; ++i) {
				temp = temp + s[i][j];
			}
			if(temp != initRowSum)
				return false;
		}
		//check if left diagonal of  matches initRowSum
		for (int i= 0; i <s.length; ++i) {
			diagSum = diagSum + s[i][i];
		}
		if(diagSum != initRowSum)
			return false;
		
		//check if right diagonal of  matches initRowSum
		diagSum =0; //reset
		for (int i= 0; i <s.length; ++i) {
			diagSum = diagSum + s[s.length -1 -i][i];
		}
		if(diagSum != initRowSum)
			return false;
		return true;
	}
	
	// Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
    	//find the magic constant
    	
    	return mc;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
                System.out.println(s[i][j]);
            }
        }

        int result = formingMagicSquare(s);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


