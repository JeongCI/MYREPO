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
import com.pcwk.ehr.cmn.SearchVO;
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
		int flag = 0;
		String statement = NAMESPACE +DOT+"doUpdate";
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		LOG.debug("│statement : "+ statement);
		flag = sqlSessionTemplate.update(statement, inVO);
		LOG.debug("│flag : "+ flag);
		LOG.debug("└───────────────────────────────────┘");
		
		return flag;
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		UserVO outVO = null;
		String statement = NAMESPACE +DOT+"doSelectOne";
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		LOG.debug("│statement : "+ statement);
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("│outVO : "+ outVO);
		LOG.debug("└───────────────────────────────────┘");
		
		return outVO;
	}

	@Override
	public List<UserVO> doRetrieve(DTO inVO) throws SQLException {
		SearchVO search = (SearchVO) inVO;
		List<UserVO> list = new ArrayList<UserVO>();
		String statement = NAMESPACE +DOT+"doRetrieve";
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		LOG.debug("│statement : "+ statement);
		list = sqlSessionTemplate.selectList(statement, search);
		for(UserVO vo : list) {
			LOG.debug("│vo : "+ vo);
		}
		LOG.debug("└───────────────────────────────────┘");
		return list;
	}

	@Override
	public List<UserVO> getAll(UserVO inVO) throws SQLException {
		List<UserVO> list = null;
		String statement = NAMESPACE +DOT+"getAll";
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		LOG.debug("│statement : "+ statement);
		list = sqlSessionTemplate.selectList(statement, inVO);
		for(UserVO vo : list) {
			LOG.debug("│vo : "+ vo);
		}
		LOG.debug("└───────────────────────────────────┘");
		
		return list;
	}

	@Override
	public int getCount(UserVO inVO) throws SQLException {
		int count = 0;
		String statement = NAMESPACE +DOT+"getCount";
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		LOG.debug("│statement : "+ statement);
		count = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("│count : "+ count);
		LOG.debug("└───────────────────────────────────┘");
		return count;
	}

}