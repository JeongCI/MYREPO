package com.pcwk.ehr.library.domain;

import com.pcwk.ehr.cmn.DTO;

public class Book extends DTO {
	// 메서드와 변수는 Camel case : ex) publicationDate
	
	// 클래스는 pascal case : ex) BookMng
	
	// 도서번호 : ISBN				String
	private String isbn;
	
	// 제목 : title				String
	private String title;
	
	// 저자 : author				String
	private String author;
	
	// 장르 : genre				String
	private String genre;
	
	// 출판일 : publicationDate	String
	private String publicationDate;
	
	 // 대출가능 여부: loan			boolean
	private boolean isBorrow;
	
	public Book() {
		
	}

	public Book(String isbn, String title, String author, String genre, String publicationDate, boolean isBorrow) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publicationDate = publicationDate;
		this.isBorrow = isBorrow;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public boolean isBorrow() {
		return isBorrow;
	}

	public void setBorrow(boolean isBorrow) {
		this.isBorrow = isBorrow;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", genre=" + genre
				+ ", publicationDate=" + publicationDate + ", isBorrow=" + isBorrow + "]";
	}
	
	
	
	
	
}
