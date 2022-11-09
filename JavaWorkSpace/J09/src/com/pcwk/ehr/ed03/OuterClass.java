package com.pcwk.ehr.ed03;

public class OuterClass {
	// 인스턴스 클래스
	class InstanceInner {
	}

	// 스태틱 클래스
	static class StaticInner {
	}

	// 사용 방법
	InstanceInner iInner = new InstanceInner(); // 인스턴스 클래스 생성
	StaticInner sInner = new StaticInner(); // 스태틱 클래스 생성

	void instanceMethod() {
		InstanceInner iInner02 = new InstanceInner(); // 인스턴스 클래스 생성
		StaticInner sInner02 = new StaticInner(); // 스태틱 클래스 생성

	}

	static void staticMethod() {
//		InstanceInner iInner03 = new InstanceInner(); // 인스턴스 클래스 생성 불가
		StaticInner sInner03 = new StaticInner(); // 스태틱 클래스 생성

	}

}
