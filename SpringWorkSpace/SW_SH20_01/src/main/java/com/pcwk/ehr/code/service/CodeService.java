package com.pcwk.ehr.code.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.code.domain.CodeVO;

public interface CodeService{
	
	/**
	 * ์ฝ๋ ์กฐํ
	 * @param list
	 * @return List<CodeVO>
	 * @throws SQLException
	 */
	public List<CodeVO> doRetrive(List<String> list) throws SQLException;
	
}
