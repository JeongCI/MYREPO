package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {
	
	final String DB_DRIVER 	= "oracle.jdbc.driver.OracleDriver";//DRIVER
	final String DB_URL		= "jdbc:oracle:thin:@192.168.3.101:1521:XE";//URL
	final String DB_ID 		= "SPRING";//ID
	final String DB_PASS 	= "pcwk";//PASSWORD
	
	final Logger LOG = LogManager.getLogger(UserDao.class);
	
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		//외부에서 주입
		this.connectionMaker = connectionMaker;
	}
	
	//단건조회
	public UserVO get(String id)throws SQLException, ClassNotFoundException{
		UserVO userVO = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		c = connectionMaker.makeConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u_id,   \n");
		sb.append("       name,   \n");
		sb.append("       passwd  \n");
		sb.append("FROM HR_MEMBER \n");
		sb.append("WHERE u_id = ? \n");
		
		LOG.debug("1. sql log \n"+sb.toString());
		LOG.debug("2. param log \n"+id);
		
		ps = c.prepareStatement(sb.toString());
		ps.setString(1, id);
		
		rs = ps.executeQuery();
		if(rs.next() == true) {
			userVO = new UserVO();
			userVO.setuId(rs.getString("u_id"));
			userVO.setName(rs.getString("name"));
			userVO.setPassWd(rs.getString("passwd"));
		}
		
		LOG.debug("3. userVO: " + userVO);	
		
		//생성 역순으로 끊기
		rs.close();
		ps.close();
		c.close();
		
		
		return userVO;
	}
	
	//데이터 등록
	public int add(UserVO inVO)throws SQLException, ClassNotFoundException{
		int flag = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
			c = connectionMaker.makeConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO hr_member ( \n");
			sb.append("    u_id,               \n");
			sb.append("    name,               \n");
			sb.append("    passwd              \n");
			sb.append(") VALUES (              \n");
			sb.append("    ?,                  \n");
			sb.append("    ?,                  \n");
			sb.append("    ?                   \n");
			sb.append(")                       \n");
			
			LOG.debug("1. sql log \n"+sb.toString());
			LOG.debug("2. param log \n"+inVO);
			
			ps = c.prepareStatement(sb.toString());
			ps.setString(1, inVO.getuId());
			ps.setString(2, inVO.getName());
			ps.setString(3, inVO.getPassWd());
			
			//sql수행
			flag = ps.executeUpdate();
			LOG.debug("3. flag: " + flag);
			
		ps.close();
		c.close();
		
		LOG.debug("1. DRIVER loading 성공");
		LOG.debug("2. Connection 성공: "+c);
		return flag;
	}
	
	
	
}
