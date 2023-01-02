package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

	final String DB_DRIVER 	= "oracle.jdbc.driver.OracleDriver";//DRIVER
	final String DB_URL		= "jdbc:oracle:thin:@192.168.3.101:1521:XE";//URL
	final String DB_ID 		= "SPRING";//ID
	final String DB_PASS 	= "pcwk";//PASSWORD	
	
	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PASS);
		System.out.println("=====================================");
		System.out.println("=NUserDao Connection = "+conn);
		System.out.println("=====================================");
		
		return conn;
	}

}
