package com.practice;

import java.util.ArrayList;

public class PracticeLambda {
	
	public static void main(String[] args) { 
        // create an ArrayList which going to 
        // contains a list of Student names which is actually 
        // string values 
        ArrayList<String> students = new ArrayList<String>(); 
  
        // Add Strings to list 
        // each string represents student name 
        students.add("Ram"); 
        students.add("Mohan"); 
        students.add("Sohan"); 
        students.add("Rabi"); 
  
        // print result 
        System.out.println("list of Students:"); 
  
        // forEach method of ArrayList and 
        // print student names 
        students.forEach((n) -> print(n)); 
    } 
  
    // printing student name 
    public static void print(String n) 
    { 
        System.out.println("Student Name is " + n); 
    } 
} 


