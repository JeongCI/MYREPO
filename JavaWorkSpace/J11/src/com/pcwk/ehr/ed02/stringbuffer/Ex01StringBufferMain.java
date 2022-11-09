package com.pcwk.ehr.ed02.stringbuffer;

public class Ex01StringBufferMain {

	public static void main(String[] args) {
		// StringBuffer vs  StringBuilder
		// Thread safe 	vs  Thread unsafe
		// 처리속도 느리다. 	vs  처리속도 빠르다.
		
		StringBuffer sb = new StringBuffer(); // 16char 저장 공간 할당, 그 이상이 되면 자동증가.
		sb.append(23);
		sb.append("age");
		sb.append(23.8);
//		sb.append("123456789012");
		
		System.out.println("sb : " + sb.toString());
		System.out.println("length : " + sb.length()); // 입력된 문자열 길이
		System.out.println("capcity : " + sb.capacity()); // 담을 수 있는 문자열 길이
	}

}