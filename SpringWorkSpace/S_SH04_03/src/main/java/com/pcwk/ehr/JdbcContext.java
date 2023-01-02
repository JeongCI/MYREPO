package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcContext {
	final Logger LOG = LogManager.getLogger(getClass());
	private DataSource dataSource;
	
	public JdbcContext() {}
	//DataSource를 DI받을 수 있도록 준비
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	// 변하지 않는 부분 생성
	   public int workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
	      int flag = 0;
	      Connection c = null;
	      PreparedStatement ps = null;
	      try {
	         c = dataSource.getConnection();
	         // --------------------------------------------------------------
	         ps = stmt.makePreparedStatement(c);
	         // --------------------------------------------------------------
	         flag = ps.executeUpdate();
	      } catch (SQLException e) {
	         throw e;
	         // 자원반납 : finally는 예외가 발생하든, 그렇지 않든 무조건 수행!
	      } finally {
	         if (null != ps) {
	            try {
	               ps.close();
	            } catch (SQLException e) {}
	         }
	         if (null != c) {
	            try {
	               c.close();
	            } catch (SQLException e) {}
	         }
	      }
	      LOG.debug("===========================");
	      LOG.debug("3. flag: " + flag);
	      LOG.debug("===========================");
	      return flag;
	   }
}
