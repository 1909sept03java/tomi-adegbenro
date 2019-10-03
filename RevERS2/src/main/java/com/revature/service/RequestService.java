package com.revature.service;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.RequestDAO;
import com.revature.dao.RequestDAOImpl;

public class RequestService {
	private RequestDAO request =  new RequestDAOImpl();

	public RequestService() {
		super();
	}
	
	public Request getMyRequestById(Employee e, int reqId) {
		return request.getMyRequestById(e, reqId);
	}
	
	public ArrayList<Request> getMyRequests(Employee e){
		return request.getMyRequests(e);
	}
	
	public Request getMyTeamRequestById(Employee e, int reqId) {
		return request.getMyTeamRequestById(e, reqId);
		
	}
	
	public ArrayList<Request> getMyTeamRequests(Employee e) {
		return request.getMyTeamRequests(e);
	}
	
	public ArrayList<Request> getMyRequestByStatus(Employee e, int s){
		return request.getMyRequestByStatus(e, s);
	}
	
	public ArrayList<Request> getMyTeamRequestsByStatus(Employee e, int s){
		return request.getMyTeamRequestsByStatus(e, s);
	}
	
	public boolean createRequest(Employee e, String t, String sm, float a){
		return request.createRequest(e, t, sm, a);
	}

}
