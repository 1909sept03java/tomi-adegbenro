package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public interface RequestDAO {
	
	public Request getMyRequestById(Employee emp, int reqId);
	public ArrayList<Request> getMyRequestByStatus(Employee emp, int stat);
	public ArrayList<Request> getMyRequests(Employee emp);
	public Request getMyTeamRequestById(Employee emp, int reqId);
	public ArrayList<Request> getMyTeamRequestsByStatus(Employee emp, int stat);
	public ArrayList<Request> getMyTeamRequests(Employee emp);
	public boolean createRequest(Employee emp, String title, String sum, float amt);
	
}
