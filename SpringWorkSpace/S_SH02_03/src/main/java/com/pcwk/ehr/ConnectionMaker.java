package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	
	/**
	 * Connection생성 interface
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public abstract Connection makeConnection() throws ClassNotFoundException, SQLException;
		
		
}
