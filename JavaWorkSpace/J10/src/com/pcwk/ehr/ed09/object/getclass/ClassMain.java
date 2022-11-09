package com.pcwk.ehr.ed09.object.getclass;

public class ClassMain {

	public static void main(String[] args) {
		Card c01 = new Card("Heart", 3);
		System.out.println(c01);

		try {
			Card c02 = Card.class.newInstance();
			System.out.println(c02);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		// 다른 방식으로 객체를 사용할 수 있다. (변수, 함수)
		Class cObj = c01.getClass();
		// 클래스 이름
		System.out.println(cObj.getName());
		// 메서드 호출
		System.out.println(cObj.toString());

	}

}
