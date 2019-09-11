package com.hw1.q7;

/*
 * Sort two Employees based on their name, department and age
 * using the Comparator interface
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsingComparator {
	
	public static void main(String[] args) {
		
		List<Employee> company = new ArrayList<Employee>();
		
		//Create employee objects
		Employee emp1 = new Employee("John", "Accounting", 25);
		Employee emp2 = new Employee("Jane", "Engineering", 30);
		Employee emp3 = new Employee("Adam", "Accounting", 48);
		Employee emp4 = new Employee("Edward", "IT", 25);
		
		//Add objects to ArrayList
		company.add(emp1);
		company.add(emp2);
		company.add(emp3);
		company.add(emp4);
		
		//Before sorting
		System.out.println("Employee List before Sorting");
		for(Employee e:company) {
			System.out.println(e.getName()+" : "+e.getDepartment()+" : "+ e.getAge());
		}
		//Sorting by Employee Name
		System.out.println("Employee List Sorted by Name");
		Collections.sort(company, new EmployeeNameSort());
		for(Employee e:company) {
			System.out.println(e.getName()+" : "+e.getDepartment()+" : "+ e.getAge());
		}
		
		//Sorting by Employee Dept
		System.out.println("Employee List Sorted by De");
		Collections.sort(company, new EmployeeDeptSort());
		for(Employee e:company) {
			System.out.println(e.getName()+" : "+e.getDepartment()+" : "+ e.getAge());
				}
		
		//Sorting by Employee Age
		System.out.println("Employee List Sorted by Age");
		Collections.sort(company, new EmployeeAgeSort());
		for(Employee e:company) {
			System.out.println(e.getName()+" : "+e.getDepartment()+" : "+ e.getAge());
		}
	}
	 
	

}
