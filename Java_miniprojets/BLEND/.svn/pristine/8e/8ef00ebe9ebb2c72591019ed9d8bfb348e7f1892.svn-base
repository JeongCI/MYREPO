package cmn;

/**
 * DAO 표준화 interface
 * 
 *
 */
public interface WorkDiv<T> {
	
	/**
	 *  등록
	 * @param dto
	 * @return 1(성공)/0(실패)
	 */
	public abstract int doSave(T dto);//abstract생략가능
	
	
	/**
	 * 삭제
	 * @param dto
	 * @return 1(성공)/0(실패)
	 */
	public abstract int doDelete(T dto);
	
	/**
	 * 단건 조회
	 * @param dto
	 * @return DTO
	 */
	public abstract T doSelectOne(String dto);
	//파일 읽기
	//파일저장
	
	
}
