package com.pcwk.ehr.user.dao;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	
	//수정
	int doUpdate(UserVO inVO) throws SQLException;
	
	//전체 데이터 조회
	List<UserVO> getAll(UserVO inVO) throws SQLException;
	//건수 조회
	int getCount(UserVO inVO) throws SQLException;

	//단건삭제
	int deleteOne(UserVO inVO) throws SQLException;

	// 단건조회
	UserVO get(String id) throws SQLException;

	// 데이터 등록
	int add(UserVO inVO) throws SQLException;

}