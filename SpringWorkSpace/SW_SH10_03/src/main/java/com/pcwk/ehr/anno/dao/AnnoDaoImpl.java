package com.pcwk.ehr.anno.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pcwk.ehr.anno.domain.AnnoVO;
import com.pcwk.ehr.cmn.DTO;

@Repository
public class AnnoDaoImpl implements AnnoDao {

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
		outVO.setUserId(inVO.getUserId()+"_DAO");
		outVO.setuserPwd(inVO.getuserPwd()+"_DAO");
		
		return outVO;
	}

	@Override
	public List<DTO> doRetrieve(AnnoVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
