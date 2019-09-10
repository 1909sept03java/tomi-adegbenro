package com.hw1.q1;

import java.util.Scanner;

/*
 * Q1. Perform a bubble sort on the following  integer Array: 
 * 1,0, 5,6, 3,2,3,7,9,4
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		//int[] arr = {1,0,5,6,3,2,3,7,9,4};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter size of the array");
		int size = scanner.nextInt();
		int[] array = new int[size];
		
		//Reading in the Elements into the Array
		System.out.println("Enter array element (Integers please!)");
		for(int i = 0; i <array.length; i++) {
			array[i] = scanner.nextInt();
		}
		
		//Perform Bubble sort
		bubbleSort(array);
		//Print out Array
		printArray(array);
		
	}
	
	static void bubbleSort(int [] arr) {
		int n = arr.length;
		//Looping through the array
		for (int i=0; i < n-1; i++) {
			for(int j=0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	//Printing the array
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i <n; i++) {
			System.out.println(arr[i]+" ");
		}
				
	}

}
