package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoAddStatement implements StatementStrategy {
	
	final Logger LOG = LogManager.getLogger(getClass());
	UserVO userVO;
	
	public UserDaoAddStatement () {}
	

	public UserDaoAddStatement(UserVO userVO) {
		super();
		this.userVO = userVO;
	}

	@Override
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		PreparedStatement ps = null;
		
	    StringBuilder sb = new StringBuilder();
	    sb.append("INSERT INTO hr_member (   \n");
	    sb.append("    u_id,                 \n");
	    sb.append("    name,                 \n");
	    sb.append("    passwd                \n");
	    sb.append(") VALUES (                \n");
	    sb.append("    ?,                    \n");
	    sb.append("    ?,                    \n");
	    sb.append("    ?                     \n");
	    sb.append(")                         \n");

	    LOG.debug("1. sql log \n" + sb.toString());
	    LOG.debug("2. param log \n" + userVO);

	    ps = c.prepareStatement(sb.toString());
	    ps.setString(1, userVO.getuId());
	    ps.setString(2, userVO.getName());
	    ps.setString(3, userVO.getPassWd());
	    
		return ps;
	}

}
