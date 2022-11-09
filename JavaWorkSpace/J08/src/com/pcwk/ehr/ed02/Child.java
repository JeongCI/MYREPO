package com.pcwk.ehr.ed02;

public class Child extends Parent {
	
//	int x = 13;
	
	void method() {
		System.out.println("x : " + x); // 13
		System.out.println("this.x : " + this.x); // 13
		
		//부모의 멤버 변수 call
		System.out.println("super.x : " + super.x); // 11
	}

}
