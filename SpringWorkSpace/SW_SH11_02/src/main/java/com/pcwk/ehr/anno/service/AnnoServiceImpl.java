package com.pcwk.ehr.anno.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.anno.dao.AnnoDao;
import com.pcwk.ehr.anno.domain.AnnoVO;

@Service
public class AnnoServiceImpl implements AnnoService {
	
	@Autowired
	AnnoDao dao;
	
	@Override
	public AnnoVO doSelectOne(AnnoVO inVO) throws SQLException {
		System.out.println("=================================");
		System.out.println("= AnnoServiceImpl = doSelectOne ="+inVO);
		System.out.println("=================================");
		return dao.doSelectOne(inVO);
	}

}
