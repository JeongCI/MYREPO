package com.pcwk.ehr.ed07.object;

public class CardMain {

	public static void main(String[] args) {
		Card card01 = new Card();
		Card card02 = new Card();
		
		System.out.println(card01.toString()); // Object에 toString() 호출
		System.out.println(card01); // 인스턴스 이름만 주어도 내부적으로 Object에 toString() 호출
		
		
	}

}
