package com.pcwk.ehr.cmn;

public class SearchVO extends DTO{
	
	private int pageSize;//페이지 사이즈
	private int pageNo;//페이지 번호
	private String searchDiv;//검색구분
	private String searchWord;//검색어
	private String div; //게시구문(10:공지사항, 20:자유게시판)
	
	public SearchVO() {}

	public SearchVO(int pageSize, int pageNo, String searchDiv, String searchWord, String div) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.div = div;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "SearchVO [pageSize=" + pageSize + ", pageNo=" + pageNo + ", searchDiv=" + searchDiv + ", searchWord="
				+ searchWord + ", div=" + div + ", toString()=" + super.toString() + "]";
	}	

}
