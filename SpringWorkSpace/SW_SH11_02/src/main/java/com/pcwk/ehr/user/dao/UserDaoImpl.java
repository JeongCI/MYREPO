package com.pcwk.ehr.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String NAMESPACE = "com.pcwk.ehr.user";
	final String DOT = ".";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; //db연결객체
	
	public UserDaoImpl() {}
	
	@Override
	public int doSave(UserVO inVO) throws SQLException {
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		
		String statement = NAMESPACE +DOT+"doSave";
		LOG.debug("│statement : "+ statement);
		
		int flag = sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("│flag : "+ flag);
		LOG.debug("└───────────────────────────────────┘");
		return flag;
	}

	@Override
	public int doDelete(UserVO inVO) throws SQLException {
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		
		String statement = NAMESPACE +DOT+"doDelete";
		LOG.debug("│statement : "+ statement);
		
		int flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("│flag : "+ flag);
		LOG.debug("└───────────────────────────────────┘");
		return flag;
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> doRetrieve(UserVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> getAll(UserVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(UserVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}