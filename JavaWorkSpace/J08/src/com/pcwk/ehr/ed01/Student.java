package com.pcwk.ehr.ed01;

public class Student extends Person {
	
	void learn() {
		System.out.println("배우기");
	}

	@Override
	void say() {
		System.out.println("선생님 안녕하세요.");
	}

//	void say() {
//		System.out.println("선생님 안녕하세요.");
//	}
	
	
	
}
