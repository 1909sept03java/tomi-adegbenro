package com.hw1.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	static void read(String filepath) {
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			
			String currString = null;
			String[] procString;
			while((currString = br.readLine()) != null) {
				procString = currString.split(":");
				//Printing in Desired Format
				System.out.println("Name: "+procString[0]+" "+procString[1]);
				System.out.println("Age: "+procString[2]);
				System.out.println("State: "+procString[3]+" State");
				System.out.println("");
				//System.out.println(currString);
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)  {
		//String path = "src/com/revature/io/text.txt";
		String path = "src/com/hw1/q20/Data.txt";
		//write("writing this to file", path );
		read(path);
	
	}

}
