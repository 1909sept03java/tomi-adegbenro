package com.hw1.q14;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please number between 1 and 5:");
		int num = scanner.nextInt();
		String month;
		String statement;
		
		switch(num) {
		case 1: 
			month = "January"; 
			statement = "is one of the first 4 months of the year";
			System.out.println(month+" "+ statement);
			break; 
		case 2: 
			month = "February"; 
			System.out.println(month+" is the second month of the year");
			break;
		case 3: 
			month = "March";
			statement = "";
			System.out.println(month+" "+ statement);
			break;
		case 4: 
			month = "April"; 
			statement = "is one of the first 4 months of the year";
			System.out.println(month+" is the first month of the year");
			break;
		case 5: 
			month = "May"; 
			System.out.println(month+" was named after a Greek/Roman deity");
		case 6: 
			month = "June"; 
			System.out.println(month+" was named after a Greek/Roman deity");
			break;
		case 7: 
			month = "July"; 
			System.out.println(month+" was named in honor of a Roman Emperor");
		case 8: 
			month = "August"; 
			System.out.println(month+" was named in honor of a Roman Emperor");
			break;
		case 9: 
			month = "September"; 
			System.out.println(month+" is an 'Ember' month");
		case 10: 
			month = "October"; 
			System.out.println(month+" is an 'Ember' month");
		case 11: 
			month = "November"; 
			System.out.println(month+" is an 'Ember' month");
		case 12: 
			month = "December"; 
			System.out.println(month+" is an 'Ember' month");
			break;
		default: System.out.println("Number out of range"); 
	}
		scanner.close();;
}
}
