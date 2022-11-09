package com.pcwk.ehr.ed09;

public class TestClass {
	int age; // 인스턴스 변수
	static int nai; // 클래스 변수
	
	
	void pcwkInstanceCall() { // 인스턴스 메서드
		System.out.println(age); // 인스턴스 변수 사용 가능
		System.out.println(nai); // 클래스 변수 사용 가능
	}
	
	static void pcwkStaticCall() { // 
		System.out.println(nai);
//		System.out.println(age); 
	}

}