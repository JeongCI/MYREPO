package com.pcwk.ehr.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.WorkDiv;
import com.pcwk.ehr.user.domain.LevelPieVO;
import com.pcwk.ehr.user.domain.UserVO;

public interface UserDao extends WorkDiv<UserVO> {

	
	//등급별 회원수
	List<LevelPieVO> levelPerMemberCount() throws SQLException;
	
	//비번체크
	int passCheck(UserVO inVO) throws SQLException;
	
	//id중복체크
	int idCheck(UserVO inVO) throws SQLException;
    //전체 데이터 조회
	List<UserVO> getAll(UserVO inVO) throws SQLException;
    //건수 조회
	int getCount(UserVO inVO) throws SQLException;

	
}