package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.service.ConnectionService;

public class BearDAOImpl implements BearDAO {
	
	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		// try-with-resources.. con will be closed at the end of the block
		try (Connection con = ConnectionService.getConnection()) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.WEIGHT, B.BIRTHDATE, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME " + 
					"FROM BEAR B " + 
					"INNER JOIN BEAR_TYPE BT " + 
					"ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID " + 
					"INNER JOIN CAVE C " + 
					"ON B.CAVE_ID = C.CAVE_ID " + 
					"ORDER BY B.BEAR_ID";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int bearId  = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_NAME");
				double weight  = rs.getDouble("WEIGHT");
				LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int caveId  = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears  = rs.getInt("MAX_BEARS");
				int bearTypeId  = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				bl.add(new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears), new BearType(bearTypeId, bearTypeName),weight, birthdate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		Bear b = null;
		// try-with-resources.. con will be closed at the end of the block
		try (Connection con = ConnectionService.getConnection()) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entry onto a Bear
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.WEIGHT, B.BIRTHDATE, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME " + 
					"FROM BEAR B " + 
					"INNER JOIN BEAR_TYPE BT " + 
					"ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID " + 
					"INNER JOIN CAVE C " + 
					"ON B.CAVE_ID = C.CAVE_ID " + 
					"WHERE B.BEAR_ID = ? " +
					"ORDER BY B.BEAR_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(); //if we are changing anything, use executeUpdate()
			if(rs.next()) {
				int bearId  = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_NAME");
				double weight  = rs.getDouble("WEIGHT");
				LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int caveId  = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears  = rs.getInt("MAX_BEARS");
				int bearTypeId  = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				b = new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears), new BearType(bearTypeId, bearTypeName),weight, birthdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public double feedBear(int bearId, int hiveId, double amt) {
		double amtFed = 0;
		CallableStatement cs = null;
		
		try(Connection con = ConnectionService.getConnection()){
			
			String sql = "{call SP_FEED_BEAR(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, bearId);
			cs.setInt(2, hiveId);
			cs.setDouble(3, amt);
			cs.registerOutParameter(4,java.sql.Types.DECIMAL);
			cs.execute();
			amtFed = cs.getDouble(4);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return amtFed;
	}

	@Override
	public boolean createBear(Bear bear) {
		// TODO Auto-generated method stub
		return false;
	}

}
