package org.audi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.audi.beans.UserBean;
import org.audi.util.DBcon;

public class DeleteContDAO implements DeleteCont {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Integer resc = 0;
	String sql = " delete from contlist where mobile = ? and userid = ?";
	
	
	@Override
	public boolean deleteCont(UserBean user, long mobile) {
		
			con = DBcon.getDB(); 
		   
		   try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, mobile );
			pstmt.setInt(2,user.getUserid() );
			
			resc = pstmt.executeUpdate();
			
			if(resc > 0 ) {
				return true;
			}
			
			
		} catch (SQLException e) {
			System.out.println("cont not deleted somthing is wrong");
			e.printStackTrace();
		}
		return false;
		   
		   
	}

}
