package org.audi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.audi.util.DBcon;

public class AllContTesttry {
	
	public static void main(String[] args) {
		Connection con = null;
		int userid = 12338;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer resc = 0;
		String sql = " select * from contlist where userid = ?";
		
			// set the value to pstmt 
			try {

				con = DBcon.getDB();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userid);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getInt("userid"));
					System.out.println(rs.getString("contname"));
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			// execute query 
		
		 
	}

}
