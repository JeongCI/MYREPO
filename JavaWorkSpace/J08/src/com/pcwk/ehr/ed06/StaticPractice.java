package com.pcwk.ehr.ed06;

public class StaticPractice {

	public static int num = 11;

	static {
		// 클래스 초기화 블럭
		// static 변수의 복잡한 초기화에 사용.
		System.out.println("클래스 초기화 블럭");
	}

	public StaticPractice() {
		System.out.println("default 생성자");
	}

	public static void say() {
		System.out.println("인스턴스를 생성하지 않고 사용 가능.");
	}

	public void hi() {
		System.out.println("인스턴스를 생성해야 가능.");
	}
}