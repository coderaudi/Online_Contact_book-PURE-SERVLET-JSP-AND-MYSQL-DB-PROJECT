package org.audi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.audi.beans.UserBean;
import org.audi.util.DBcon;

public class UserDAO implements UserAc {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Integer resc = 0;
	//String sql = "insert into user values (?,?,?,?,?)";
	String sql = "insert into user( username , password , email, mobile ) values ( ? , ? , ? , ? )";
	
	public UserBean createAc(UserBean user) {
		
		con = DBcon.getDB();
		try {
			pstmt = con.prepareStatement(sql);
			// set the data 
			//pstmt.setInt(1, user.getUserid());
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setLong(4, user.getMobile());
			resc = pstmt.executeUpdate();	
			user.setMsg("Account created Successfully !");
		} 
		 catch (SQLException e) {
			 	System.out.println("User already  present ..");
			 	return null;
		}
		return user;
	}

}
