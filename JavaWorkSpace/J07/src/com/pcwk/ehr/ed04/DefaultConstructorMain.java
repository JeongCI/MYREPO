package com.pcwk.ehr.ed04;

public class DefaultConstructorMain {

	public static void main(String[] args) {
		NAge na = new NAge();
		
		// default 생성자는 클래스에 생성자가 1개라도 있는
		// 경우 default생성자를 JVM이 생성하지 않는다.
		Nai nai = new Nai();
	}

}
