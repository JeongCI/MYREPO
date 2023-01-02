package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleConnectionMaker {
	
	final String DB_DRIVER 	= "oracle.jdbc.driver.OracleDriver";//DRIVER
	final String DB_URL		= "jdbc:oracle:thin:@192.168.3.101:1521:XE";//URL
	final String DB_ID 		= "SPRING";//ID
	final String DB_PASS 	= "pcwk";//PASSWORD		
	
	final Logger LOG = LogManager.getLogger(SimpleConnectionMaker.class);
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PASS);
		LOG.debug("=====================================");
		LOG.debug("=Connection = "+conn);
		LOG.debug("=====================================");
		
		return conn;		
	}
	
	
}
