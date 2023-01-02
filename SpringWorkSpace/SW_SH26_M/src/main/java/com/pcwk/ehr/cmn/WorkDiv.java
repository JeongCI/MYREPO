package com.pcwk.ehr.cmn;

import java.sql.SQLException;
import java.util.List;

public interface WorkDiv<T> {

	
	final String DOT       = ".";
	/**
	 * 등록
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doSave(T inVO)throws SQLException;
	
	/**
	 * 삭제
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(T inVO)throws SQLException;
	
	/**
	 * 수정
	 * @param t
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(T inVO)throws SQLException;
	
	
	/**
	 * 단건조회
	 * @param t
	 * @return T
	 * @throws SQLException
	 */
	T doSelectOne(T inVO)throws SQLException;
	
	/**
	 * 목록조회
	 * @param t
	 * @return List<DTO>
	 * @throws SQLException
	 */
	List<T> doRetrive(DTO inVO)throws SQLException;
	
	
	
}
