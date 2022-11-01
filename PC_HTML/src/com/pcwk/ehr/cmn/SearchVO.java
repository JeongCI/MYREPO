/**
* <pre>
* com.pcwk.ehr.cmn
* Class Name : SearchVO.java
* Description:
* Author: ITSC
* Since: 2022/09/27
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/09/27 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.cmn;

/**
 * @author ITSC
 *
 */
public class SearchVO extends DTO {
	private int pageSize;		//페이지 사이즈
	private int pageNo;			//페이지 번호
	private String searchDiv;	//검색구분 : ""(전체),10(제목), 20(내용)
	private String searchWord;	//검색어
	
	public SearchVO() {
		pageSize = 10;
		pageNo = 1;
		searchDiv = "";
		searchWord = "";
	}

	/**
	 * @param pageSize
	 * @param pageNo
	 * @param searchDiv
	 * @param searchWord
	 */
	public SearchVO(int pageSize, int pageNo, String searchDiv, String searchWord) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the searchDiv
	 */
	public String getSearchDiv() {
		return searchDiv;
	}

	/**
	 * @param searchDiv the searchDiv to set
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	/**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "SearchVO [pageSize=" + pageSize + ", pageNo=" + pageNo + ", searchDiv=" + searchDiv + ", searchWord="
				+ searchWord + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
