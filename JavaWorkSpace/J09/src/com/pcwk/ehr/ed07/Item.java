package com.pcwk.ehr.ed07;

public class Item {
/*
"title":"오라클 (입문서)",
"link":"https:\/\/search.shopping.naver.com\/book\/catalog\/32441783777",
"image":"https:\/\/shopping-phinf.pstatic.net\/main_3244178\/32441783777.20220518183834.jpg",
"author":"Michael Abbey",
"discount":"27000",
"publisher":"지샘",
"pubdate":"19970315",
"isbn":"9788988462096",
"description":""

 */
	
	private String title;		// 제목
	private String link;		// 링크
	private String image;		// 이미
	private String aughor;		// 저자
	private String discount;	// 가격
	private String publisher;	// 출판사
	private String pubdate;		// 출판일
	private String isbn;		// ISBN
	
	public Item() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAughor() {
		return aughor;
	}

	public void setAughor(String aughor) {
		this.aughor = aughor;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", image=" + image + ", aughor=" + aughor + ", discount="
				+ discount + ", publisher=" + publisher + ", pubdate=" + pubdate + ", isbn=" + isbn + "]";
	}
	
}
