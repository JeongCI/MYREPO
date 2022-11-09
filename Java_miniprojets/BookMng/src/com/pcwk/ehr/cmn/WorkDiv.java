package com.pcwk.ehr.cmn;

import java.util.List;

/**
 * DAO(Data Access Object) 표준화 interface
 * @author ITSC
 *
 */
public interface WorkDiv<T> {
	
	/**
	 * 목록조회
	 * @param dto
	 * @return List<DTO>
	 */
	public abstract List<T> doRetrieve(DTO dto);
	
	/**
	 * 등록
	 * @param dto
	 * @return 1(성공), 0(실패)
	 */
	public abstract int doSave(T dto);

	/**
	 * 수정
	 * @param dto
	 * @return 1(성공), 0(실패)
	 */
	public int doUpdate(T dto);
	
	/**
	 * 삭제
	 * @param dto
	 * @return 1(성공), 0(실패)
	 */
	public int doDelete(T dto);
	
	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	T doSelectOne(T dto);
	
	// 파일읽기
	// 파일저장
}
