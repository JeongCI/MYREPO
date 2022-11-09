package com.pcwk.ehr.ed09;

public class TestMethod {

	public TestMethod() {
		
	}
	
	void instanceMethod() {} // 인스턴스 메서드
	static void staticMethod() {} // static 메서드
	
	void pcwkInstanceCall() { // 인스턴스 메서드
		instanceMethod();
		staticMethod();
	}
	
	static void pcwkStaticCall() {
		// 인스턴스 멤버가 존재하는 시점에 
		// 클래스 멤버는 항상 존재하지만, 클래스 멤버가 존재하는 시점에
		// 인스턴스 멤버가 존재하지 않을 수도 있다.
//		instanceMethod(); 오류 
		staticMethod();
	}

}