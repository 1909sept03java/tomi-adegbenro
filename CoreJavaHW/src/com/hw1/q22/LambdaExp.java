package com.hw1.q22;

public class LambdaExp {
	public static void main(String[] args) {
		FuncInterface fobj = (int x, int y)->System.out.println(x*y);
		
		//Calling the lambda expression
		fobj.abstractFunction(5, 2);
	}

}

interface FuncInterface{
	//creating the abstract function
	void abstractFunction(int x, int y);
	
}
