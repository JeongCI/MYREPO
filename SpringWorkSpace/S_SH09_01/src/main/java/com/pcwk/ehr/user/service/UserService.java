package com.pcwk.ehr.user.service;

import java.sql.SQLException;

import com.pcwk.ehr.UserVO;

public interface UserService {
	
	/**
	 * 등업기능
	 * @param inVO
	 * @throws SQLException
	 */
	public void upgradeLevels(UserVO inVO) throws SQLException; 
	
	/**
	 * 신규 회원 로직
	 * @param inVO
	 * @throws SQLException 
	 */
	public void add(UserVO inVO) throws SQLException;
}
