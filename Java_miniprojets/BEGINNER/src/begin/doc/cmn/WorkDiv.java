package begin.doc.cmn;

import java.util.List;

import begin.doc.domain.Site;

/**
 * DAO(Data Access dto) 표준화 interface
 * @author ITSC
 *
 */
public interface WorkDiv<T> {
	
	/**
	 * 목록 조회 (회원, 카테고리, 사이트 공통)
	 * @param DTO
	 * @return List<DTO>
	 */
	public abstract List<T> doRetrieve(DTO dto);
	
	
	/**
	 * 등록 (회원, 카테고리, 사이트 공통)
	 * @param DTO
	 * @return 1(성공) / 0(실패)
	 */
	int doSave(T dto);
	
	
	/**
	 * 수정 (사이트)
	 * @param DTO
	 * @return 1(성공) / 0(실패)
	 */
	int doUpdate(T dto);
	
	
	/**
	 * 삭제 (회원, 카테고리, 사이트 공통)
	 * @param DTO
	 * @return 1(성공) / 0(실패)
	 */
	int doDelete(T dto);
	
	
	/**
	 * 찾기 (회원)
	 * @param dto
	 * @return
	 */
	int doFind(T dto);
	
	/** 2022-09-11
	 * 중복방지를 위한 존재 확인 (회원, 카테고리, 사이트 공통)
	 * @param dto
	 * @return
	 */
	boolean isExists(T dto);


}
