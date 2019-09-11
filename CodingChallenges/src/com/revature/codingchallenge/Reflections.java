package com.revature.codingchallenge;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Reflections {
	
	
	
	public static void main(String args[]) throws Exception { 
        //Object obj;
		// Creating object whose property is to be checked 
        Test obj = new Test(); 
		//obj.new Test();
  
		// Creating class object from the object using 
        // getclass method 
        Class cls = obj.getClass(); 
        System.out.println("The name of class is " + 
                            cls.getName()); 
  
        // Getting the constructor of the class through the 
        // object of the class 
        Constructor constructor = cls.getConstructor(); 
        System.out.println("The name of constructor is " + 
                            constructor.getName()); 
  
        System.out.println("The public methods of class are : "); 
  
        // Getting methods of the class through the object 
        // of the class by using getMethods 
        Method[] methods = cls.getMethods(); 
        
        // Printing method names 
        for (Method method:methods) {
        	System.out.println(method.getName());
        }
	}
         

}

class Test 	{ 
    // creating a private field 
    private String s; 
  
    // creating a public constructor 
    public Test()  {  s = "Testing Reflections"; } 
  
    // Creating a public method with no arguments 
    public void method1()  { 
        System.out.println("The string is " + s); 
    } 
  
    // Creating a public method with int as argument 
    public void method2(int n)  { 
        System.out.println("The number is " + n); 
    } 
  
    // creating a private method 
    private void method3() { 
        System.out.println("Private method invoked"); 
    } 
} 
