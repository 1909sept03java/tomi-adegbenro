package com.revature.main;

//import java.sql.Connection;

//import com.revature.util.ConnectionUtil;
import com.revature.beans.Employee;
//import com.revature.util.ConnectionUtil;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImplementation;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDAO ed = new EmployeeDAOImplementation();
		for (Employee e : ed.getEmployees()) {
			System.out.println(e);
		
		}

	}
}