package begin.doc.domain;

import begin.doc.cmn.DTO;

public class Search extends DTO {
		
	private int searchDiv;
	private String searchWord;
	
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

