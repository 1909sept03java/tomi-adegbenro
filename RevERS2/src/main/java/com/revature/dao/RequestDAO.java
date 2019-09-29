package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public interface RequestDAO {
	
	public Request getRequest(Employee emp, int reqId);
	public ArrayList<Request> getMyRequests(Employee emp);
	//public ArrayList<Request> getMyTeamRequests(Employee emp);
	
	//public ArrayList<Request> createNewRequest(Employee emp);

}
