package com.pcwk.ehr.ed07.object;

public class Card {

	String kind; // 종류
	int number; // 숫자
	
	public Card() {
		this("Spade",1);
	}
	
	public Card(String kind, int number) {
		super();
		this.kind = kind;
		this.number = number;
	}
}
