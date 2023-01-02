package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoDeleteOne implements StatementStrategy {

	   final Logger LOG = LogManager.getLogger(getClass());
	   
	   private UserVO userVO;
	   
	   public UserDaoDeleteOne() {}
	   
	   public UserDaoDeleteOne(UserVO userVO) {
	      super();
	      this.userVO = userVO;
	   }



	   @Override
	   public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
	      PreparedStatement ps = null; 
	      StringBuilder sb = new StringBuilder();
	      sb.append("DELETE FROM hr_member  \n");
	      sb.append("WHERE u_id = ?         \n");
	      
	      LOG.debug("1. sql log \n" + sb.toString());
	      LOG.debug("2. param :" + userVO);
	      
	      ps = c.prepareStatement(sb.toString());
	      ps.setString(1, userVO.getuId());
	      
	      return ps;
	   }
	   
	   

	}
