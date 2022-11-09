package com.pcwk.ehr.library.domain;

import com.pcwk.ehr.cmn.DTO;

public class Search extends DTO {
	// 겁색구분 : 제목(10), 저자(20)
	// 검색어
	
	private int serachDiv; // 제목(10), 저자(20), 전체(100)
	private String searchWord; // 검색어
	
	public Search() {}

	public Search(int serachDiv, String searchWord) {
		super();
		this.serachDiv = serachDiv;
		this.searchWord = searchWord;
	}

	public int getSerachDiv() {
		return serachDiv;
	}

	public void setSerachDiv(int serachDiv) {
		this.serachDiv = serachDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "Search [serachDiv=" + serachDiv + ", searchWord=" + searchWord + "]";
	}
	
	
}
