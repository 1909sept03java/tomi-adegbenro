package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.service.ConnectionService;

public class RequestDAOImpl implements RequestDAO{

	@Override
	public ArrayList<Request> getMyRequestById(Employee emp, int req_Id) {
		int emp_Id = emp.getEmpId();
		Request myRequest = null;
		ArrayList<Request> myReq = new ArrayList<Request>();
				
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT * FROM REQUEST WHERE REQ_EMP = ? AND REQ_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_Id);
			pstmt.setInt(2, req_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			if(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				String title = rs.getString("TITLE");
				String summary = rs.getString("SUMMARY");
				int reqEmp = rs.getInt("REQ_EMP");
				float amount = rs.getFloat("AMOUNT");
				Date reqDate = rs.getDate("REQ_DATE");
				int status = rs.getInt("STATUS");
				Date statusDate = rs.getDate("STATUS_DATE");
				myRequest = new Request(reqId, title, summary, reqEmp, amount, reqDate, status, statusDate);
				myReq.add(myRequest);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Request>)myReq;
	}

	@Override
	public ArrayList<Request> getMyRequests(Employee emp) {
		ArrayList<Request> myRequests = new ArrayList<Request>();
		int emp_Id = emp.getEmpId();
		
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT * FROM REQUEST WHERE REQ_EMP = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				String title = rs.getString("TITLE");
				String summary = rs.getString("SUMMARY");
				int reqEmp = rs.getInt("REQ_EMP");
				float amount = rs.getFloat("AMOUNT");
				Date reqDate = rs.getDate("REQ_DATE");
				int status = rs.getInt("STATUS");
				Date statusDate = rs.getDate("STATUS_DATE");
				myRequests.add(new Request(reqId, title, summary, reqEmp, amount, reqDate, status, statusDate));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Request>) myRequests;
	}

	@Override
	public ArrayList<Request> getMyTeamRequestById(Employee emp, int req_Id) {
		int emp_Id = emp.getEmpId();
		Request myTeamRequestById = null;
		ArrayList<Request> myTeamReqById = new ArrayList<Request>();
				
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, "
					+ "REQ_DATE, STATUS, STATUS_DATE "
					+ "FROM REQUEST INNER JOIN EMPLOYEE ON REQUEST.REQ_EMP = EMPLOYEE.EMP_ID "
					+ "WHERE REQUEST.REQ_ID = ? AND EMPLOYEE.MGR = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, req_Id);
			pstmt.setInt(2, emp_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			if(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				String title = rs.getString("TITLE");
				String summary = rs.getString("SUMMARY");
				int reqEmp = rs.getInt("REQ_EMP");
				float amount = rs.getFloat("AMOUNT");
				Date reqDate = rs.getDate("REQ_DATE");
				int status = rs.getInt("STATUS");
				Date statusDate = rs.getDate("STATUS_DATE");
				myTeamRequestById = new Request(reqId, title, summary, reqEmp, amount, reqDate, status, statusDate);
				myTeamReqById.add(myTeamRequestById);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Request>)myTeamReqById;
	}

	@Override
	public ArrayList<Request> getMyTeamRequests(Employee emp) {
		ArrayList<Request> myTeamRequests = new ArrayList<Request>();
		int emp_Id = emp.getEmpId();
		
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, "
					+ "REQ_DATE, STATUS ,STATUS_DATE "
					+ "FROM REQUEST INNER JOIN EMPLOYEE ON REQUEST.REQ_EMP = EMPLOYEE.EMP_ID "
					+ "WHERE EMPLOYEE.MGR = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				String title = rs.getString("TITLE");
				String summary = rs.getString("SUMMARY");
				int reqEmp = rs.getInt("REQ_EMP");
				float amount = rs.getFloat("AMOUNT");
				Date reqDate = rs.getDate("REQ_DATE");
				int status = rs.getInt("STATUS");
				Date statusDate = rs.getDate("STATUS_DATE");
				myTeamRequests.add(new Request(reqId, title, summary, reqEmp, amount, reqDate, status, statusDate));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Request>) myTeamRequests;
	}

	@Override
	public ArrayList<Request> getMyRequestByStatus(Employee emp, int stat) {
		int emp_Id = emp.getEmpId();
		ArrayList<Request> myRequestByStat = new ArrayList<Request>();
				
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, "
					+ "REQ_DATE, STATUS, STATUS_DATE "
					+ "FROM REQUEST INNER JOIN EMPLOYEE ON REQUEST.REQ_EMP = EMPLOYEE.EMP_ID "
					+ "WHERE REQUEST.STATUS = ? AND EMPLOYEE.EMP_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stat);
			pstmt.setInt(2, emp_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				String title = rs.getString("TITLE");
				String summary = rs.getString("SUMMARY");
				int reqEmp = rs.getInt("REQ_EMP");
				float amount = rs.getFloat("AMOUNT");
				Date reqDate = rs.getDate("REQ_DATE");
				int status = rs.getInt("STATUS");
				Date statusDate = rs.getDate("STATUS_DATE");
				myRequestByStat.add(new Request(reqId, title, summary, reqEmp, amount, reqDate, status, statusDate));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Request>) myRequestByStat;
	}


	public ArrayList<Request> getMyTeamRequestsByStatus(Employee emp, int stat) {
		int emp_Id = emp.getEmpId();
		ArrayList<Request> myTeamRequestByStat = new ArrayList<Request>();
				
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "SELECT REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, "
					+ "REQ_DATE, STATUS, STATUS_DATE "
					+ "FROM REQUEST INNER JOIN EMPLOYEE ON REQUEST.REQ_EMP = EMPLOYEE.EMP_ID "
					+ "WHERE REQUEST.STATUS = ? AND EMPLOYEE.MGR = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stat);
			pstmt.setInt(2, emp_Id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				String title = rs.getString("TITLE");
				String summary = rs.getString("SUMMARY");
				int reqEmp = rs.getInt("REQ_EMP");
				float amount = rs.getFloat("AMOUNT");
				Date reqDate = rs.getDate("REQ_DATE");
				int status = rs.getInt("STATUS");
				Date statusDate = rs.getDate("STATUS_DATE");
				myTeamRequestByStat.add(new Request(reqId, title, summary, reqEmp, amount, reqDate, status, statusDate));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Request>) myTeamRequestByStat;
	}
	
	public boolean createRequest(Employee emp, String title, String sum, float amt) {
		int emp_id = emp.getEmpId();
		CallableStatement cs = null;
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "{call SP_CREATE_NEW_REQUEST(?,?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, emp_id);
			cs.setString(2, title);
			cs.setString(3, sum);
			cs.setFloat(4, amt);
			cs.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean resolveRequest(Employee mgr, int req_Id, int stat) {
		int mgr_id = mgr.getEmpId();
		CallableStatement cs = null;
		try (Connection conn = ConnectionService.getConnection()){
			String sql = "{call SP_RESOLVE_REQUEST(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, req_Id);
			cs.setInt(2, stat);
			cs.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return true;
	}

	
}
