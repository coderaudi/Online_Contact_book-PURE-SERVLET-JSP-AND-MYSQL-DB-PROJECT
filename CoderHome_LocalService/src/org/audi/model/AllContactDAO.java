
package org.audi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.audi.beans.ContactBean;
import org.audi.util.DBcon;

public class AllContactDAO implements AllContact {
	Connection con = null;
	// int userid = 12312;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Integer resc = 0;
	String sql = " select * from contlist where userid = ? order by contname";
	public ArrayList<ContactBean> getAllContact(ContactBean contbean) {
		ArrayList<ContactBean> allcontlist = new ArrayList<ContactBean>();
		
		try {

			con = DBcon.getDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, contbean.getUserid());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("userid"));
				System.out.println(rs.getString("contname"));
				ContactBean cbean = new ContactBean();
				cbean.setUserid(rs.getInt("userid"));
				cbean.setName(rs.getString("contname"));
				cbean.setMobile(rs.getLong("mobile"));
				
				allcontlist.add(cbean);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();	
			return null;
		}
		
		return allcontlist;
	}

}
