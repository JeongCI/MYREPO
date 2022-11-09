package project.quack.domain;

import project.quack.cmn.DTO;

public class Search extends DTO{
//	검색구분: 메뉴번호(10), 메뉴이름(20)				
//	검색어
	
	private int searchDiv;//메뉴번호(10), 메뉴이름(20),전체(100)
	private String searchWord;//검색어
	
	public Search() {}
	
	public Search(int searchDiv, String searchWord) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}


	public int getSearchDiv() {
		return searchDiv;
	}


	public void setSearchDiv(int searchDiv) {
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
		return "Search [searchDiv=" + searchDiv + ", searchWord=" + searchWord + "]";
	}

	

	
	
	
	
	

}
