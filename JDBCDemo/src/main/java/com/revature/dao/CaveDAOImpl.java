package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl implements CaveDAO{

	@Override
	public List<Cave> getCaves() {
		// TODO Auto-generated method stub
		List<Cave> cl = new ArrayList<>();
		//try-with resources....resources included in the try args will be closed at the end of the 
		//block works with  all AutoCloseable resources
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM CAVE";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				cl.add(new Cave(caveId, caveName, maxBears));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	catch (IOException e){
		e.printStackTrace();
	}
		return cl;
	}

	@Override
	public Cave getCaveById(int id) {
		// TODO Auto-generated method stub
		Cave c = null;
		//try-with resources....resources included in the try args will be closed at the end of the 
		//block works with  all AutoCloseable resources
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM CAVE WHERE CAVE_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				c = new Cave(caveId, caveName, maxBears);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public void createCave(Cave cave) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO CAVE VALUES (?,?,?)";
			//String sql2 = "SELECT * FROM CAVE WHERE CAVE_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt.setInt(1, cave.getId());
			pstmt.setString(2, cave.getName());
			pstmt.setInt(3, cave.getMaxBears());
			pstmt.executeUpdate();
			//ResultSet rs = pstmt2.executeQuery();
			/*while(rs.next()) {
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				Cave c = new Cave(caveId, caveName, maxBears);
			}*/
		}catch (SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateCave(Cave cave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCave(Cave cave) {
		// TODO Auto-generated method stub
		
	}

}
