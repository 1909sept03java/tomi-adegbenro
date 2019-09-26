package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;

//import com.revature.beans.BankAccount;
//import com.revature.beans.BankUser;



public interface EmployeeDAO {
	public ArrayList<Request> actionRequest(Employee emp, int action);
	
}
