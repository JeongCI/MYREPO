package com.pcwk.ehr.ed04.classz;

public class CardMain {

	public static void main(String[] args) {
		System.out.println("Card.width:"+Card.width);
		System.out.println("Card.height:"+Card.height);

		Card c01=new Card();
		c01.kind = "Heart";
		c01.number = 2;
		//인스턴스 변수 객체마다 고유의 값을 가진다.
		System.out.println("c01 kind:"+c01.kind);
		System.out.println("c01 number:"+c01.number);
		
		Card c02=new Card();
		c02.kind = "Spade";
		c02.number = 8;
		//인스턴스 변수 객체마다 고유의 값을 가진다.
		System.out.println("c02 kind:"+c02.kind);
		System.out.println("c02 number:"+c02.number);	
		
		System.out.println("============================");
		
		
		//클래스 변수 확인
		c01.width  = 88;
		c01.height = 99;
		
		System.out.println("c01.width:"+c01.width);
		System.out.println("c01.height:"+c01.height);
		
		System.out.println("c02.width:"+c02.width);
		System.out.println("c02.height:"+c02.height);		
		
	}

}

