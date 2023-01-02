package com.pcwk.ehr.anno.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.anno.domain.AnnoVO;
import com.pcwk.ehr.cmn.DTO;

@Repository
public class AnnoDaoImpl implements AnnoDao {
	final Logger LOG = LogManager.getLogger(getClass());
	
	final String NAMESPACE = "com.pcwk.ehr.anno";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; //db연결객체
	
	public AnnoDaoImpl() {
		
	}
	
	@Override
	public int doSave(AnnoVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(AnnoVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(AnnoVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnnoVO doSelectOne(AnnoVO inVO) throws SQLException {
		System.out.println("=================================");
		System.out.println("= DAO = doSelectOne =");
		System.out.println("=================================");
		AnnoVO outVO = new AnnoVO();
		
		String statement = this.NAMESPACE+".doSelectOne";
		System.out.println("= statement = :"+statement);
		System.out.println("= param = :"+inVO);
		
		outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		System.out.println("= outVO = :"+outVO);
		
		return outVO;
	}

	@Override
	public List<DTO> doRetrieve(AnnoVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
