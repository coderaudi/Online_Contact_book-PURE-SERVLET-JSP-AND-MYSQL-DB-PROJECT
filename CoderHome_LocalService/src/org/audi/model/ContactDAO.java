package org.audi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.audi.beans.ContactBean;
import org.audi.util.DBcon;

public class ContactDAO implements Contact {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Integer resc = 0;
	String sql = "insert into contlist values (?,?,?)";
	
	public ContactBean addCont(ContactBean contbean) {
		
	
		try {
			con = DBcon.getDB();
			
			System.out.println("mydata to insert into db ..");

			 System.out.println( contbean.getUserid());
			 System.out.println( contbean.getName());
			System.out.println(  contbean.getMobile());
			
			pstmt = con.prepareStatement(sql);
			// set the value to pstmt
			
			System.out.println("setting val to pstmt");
			pstmt.setInt(1, contbean.getUserid());
			pstmt.setString(2, contbean.getName());
			pstmt.setLong(3, contbean.getMobile());
			System.out.println("val set done");
			
			System.out.println("excuteing query ");
			resc = pstmt.executeUpdate();
			System.out.println("excution done");
			
		} catch (SQLException e) {
			System.out.println("problem in the query eqecution ");
			e.printStackTrace();
		}
		
		if(resc != 0) {
			contbean.setMesg("Contact Added Successfully !");
			return contbean;
		}else {
			return null;
		}
	}

}
