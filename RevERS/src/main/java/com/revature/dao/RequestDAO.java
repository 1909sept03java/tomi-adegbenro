package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public interface RequestDAO {
	
	public Request viewRequest(Employee emp, int reqId);
	public ArrayList<Request> viewMyRequests(Employee emp);
	public ArrayList<Request> viewMyTeamRequests(Employee emp);
	
	//public BankAccount depositMyAccount(BankUser usr, int acctId, double dep);
	//public BankAccount withdrawMyAccount(BankUser usr, int acctId, double wd);
	public ArrayList<Request> createNewRequest(Employee emp);

}
