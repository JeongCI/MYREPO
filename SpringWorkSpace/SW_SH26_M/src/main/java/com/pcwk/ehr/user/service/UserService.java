package com.pcwk.ehr.user.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.user.domain.LevelPieVO;
import com.pcwk.ehr.user.domain.UserVO;

public interface UserService {

	/**
	 * 등급별 회원수
	 * @return List<LevelPieVO>
	 * @throws SQLException
	 */
	List<LevelPieVO> levelPerMemberCount() throws SQLException;
	

	/**
	 * 1.idCheck   = 10 (id오류) <br>
	 * 2.passCheck = 20 (비번오류)<br>  
	 * 3.id/비번 일치 = 30      
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	int idPassCheck(UserVO inVO) throws SQLException;
	
	
    /**
     * 회원 다건 삭제
     * @param users
     * @return 삭제 건수 
     * @throws SQLException
     */
	int upDeleteAll(List<UserVO> users) throws SQLException;
	
	/**
	 * id중복체크 
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	int idCheck(UserVO inVO) throws SQLException;
	
	/**
	 * 등업기능
	 * 
	 * @param inVO
	 * @throws SQLException
	 */
	public void upgradeLevels(UserVO inVO) throws SQLException;

	/**
	 * 신규 회원 등록 로직
	 * 
	 * @param inVO
	 */
	public int add(UserVO inVO) throws SQLException;

	/**
	 * 삭제
	 * 
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(UserVO inVO) throws SQLException;

	/**
	 * 수정
	 * 
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(UserVO inVO) throws SQLException;

	/**
	 * 단건조회
	 * 
	 * @param t
	 * @return T
	 * @throws SQLException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;

	/**
	 * 목록조회
	 * 
	 * @param t
	 * @return List<DTO>
	 * @throws SQLException
	 */
	List<UserVO> doRetrive(DTO inVO) throws SQLException;

	/**
	 * uId조회 건수 조회
	 * 
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int getCount(UserVO inVO) throws SQLException;

}
