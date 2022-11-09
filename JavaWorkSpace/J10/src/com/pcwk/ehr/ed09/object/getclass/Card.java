package com.pcwk.ehr.ed09.object.getclass;

public class Card {

	String kind; // 종류
	int number; // 숫자

	public Card() {
		this("Spade", 1);
	}

	public Card(String kind, int number) {
		super();
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + ", toString()=" + super.toString() + "]";
	}

//	@Override
//	public String toString() {
//		return "Card [kind=" + kind + ", number=" + number + "]";
//	}

//	@Override
//	public String toString() {
//		return "card[kind="+kind+", number="+number+"]";
//	}
}