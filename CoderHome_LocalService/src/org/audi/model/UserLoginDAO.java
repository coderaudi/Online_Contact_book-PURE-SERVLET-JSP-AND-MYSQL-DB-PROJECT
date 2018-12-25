package org.audi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.audi.beans.UserBean;
import org.audi.util.DBcon;

public class UserLoginDAO  implements UserLogin {
	Connection rcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Integer resc = 0;
	String sql = " select * from user where( username = ?  or email = ? ) and password = ?";
		
	public UserBean loginUser(UserBean user) {
		UserBean nuser  = null;
		rcon = DBcon.getDB();
		
		try {
			pstmt = rcon.prepareStatement(sql);
			// set the data 
			System.out.println("data setting");
//			pstmt.setInt(1, user.getUserid());
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
		
			rs =  pstmt.executeQuery();
			System.out.println("exectude qq");
			while(rs.next()) {
				 nuser = new UserBean();
				System.out.println(rs);
				nuser.setUserid(rs.getInt("userid"));
				nuser.setUsername(rs.getString("username"));
				nuser.setPassword(rs.getString("password"));
				nuser.setMobile(rs.getLong("mobile"));
				nuser.setEmail(rs.getString("email"));
				nuser.setMsg("Account created Successfully !");
			}
			
		} 
		 catch (SQLException e) {
			 	System.out.println("User already  present ..");
			 	return null;
		}
		return  nuser;
	}
	
}
