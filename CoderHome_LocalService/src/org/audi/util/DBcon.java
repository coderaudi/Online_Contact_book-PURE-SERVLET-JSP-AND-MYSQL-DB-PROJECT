package org.audi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon implements DBinfo {
	
	static Connection con = null;
	
	public static Connection getDB() {
		
		try {
			Class.forName(DRIVERURL); // load the driver
		con = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

}
