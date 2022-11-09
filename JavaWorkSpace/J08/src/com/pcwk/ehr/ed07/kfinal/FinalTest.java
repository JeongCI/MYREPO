package com.pcwk.ehr.ed07.kfinal;

public class FinalTest { // 더이상 상속을 허용하지 않는다.
	
	final int MAX_NUM = 10;
	
	final void getMaxNum() { // 오버라이딩을 허용하지 않는다.
		final int LV = 99; // 상수
		//MAX_NUM = 88; 상수이므로 값 변경 불가.
	}
	

}