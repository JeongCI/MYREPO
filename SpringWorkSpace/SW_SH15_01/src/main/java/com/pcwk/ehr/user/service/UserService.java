package com.pcwk.ehr.user.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.user.domain.UserVO;

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
	public int add(UserVO inVO) throws SQLException;
	
	/**
	 * 삭제
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(UserVO inVO) throws SQLException;
	
	/**
	 * 수정
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(UserVO inVO) throws SQLException;
	
	/**
	 * 단건 조회 
	 * @param t
	 * @return T
	 * @throws SQLException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;
	
	/**
	 * 목록조회
	 * @param t
	 * @return List<DTO>
	 * @throws SQLException
	 */
	List<UserVO> doRetrieve(DTO inVO) throws SQLException;
	
	/**
	 * uId조회 건수 조회
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int getCount (UserVO inVO) throws SQLException;
}
