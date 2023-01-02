package com.pcwk.ehr.board.dao;

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

import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String NAMESPACE = "com.pcwk.ehr.board";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int doSave(BoardVO inVO) throws SQLException {
		int flag = 0;
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		
		String statement = NAMESPACE +DOT+"doSave";
		LOG.debug("│statement : "+ statement);
		
		flag = sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("│flag : "+ flag);
		LOG.debug("└───────────────────────────────────┘");
		return flag;
	}
	@Override
	public int doDelete(BoardVO inVO) throws SQLException {
		int flag = 0;
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		
		String statement = NAMESPACE +DOT+"doDelete";
		LOG.debug("│statement : "+ statement);
		
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("│flag : "+ flag);
		LOG.debug("└───────────────────────────────────┘");
		return flag;
	}
	@Override
	public int doUpdate(BoardVO inVO) throws SQLException {
		return sqlSessionTemplate.update(NAMESPACE +DOT+"doUpdate", inVO);
	}
	@Override
	public BoardVO doSelectOne(BoardVO inVO) throws SQLException {
		BoardVO outVO = null;
		
		return outVO = sqlSessionTemplate.selectOne(NAMESPACE +DOT+"doSelectOne", inVO);
	}
	@Override
	public List<BoardVO> doRetrieve(DTO inVO) throws SQLException {
		SearchVO search = (SearchVO) inVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		String statement = NAMESPACE+DOT+"doRetrieve";
		LOG.debug("┌───────────────────────────────────┐");
		LOG.debug("│param : "+ inVO);
		LOG.debug("│statement : "+ statement);
		list = sqlSessionTemplate.selectList(statement, search);
		for(BoardVO vo : list) {
			LOG.debug("│vo : "+ vo);
		}
		LOG.debug("└───────────────────────────────────┘");
		return list;
	}
	
	@Override
	public int updateReadCnt(BoardVO inVO) throws SQLException {
	   return sqlSessionTemplate.update(NAMESPACE+DOT+"updateReadCnt", inVO);
	}
	

}