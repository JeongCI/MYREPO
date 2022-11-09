package com.pcwk.ehr.ed09.object.hashcode;

public class HashCodeMain {

	public static void main(String[] args) {
		String str01 = new String("KOREA IT");
		String str02 = new String("KOREA IT");
		
		// String equals override되어 있음
		// 입력된 문자열을 cahr단위로 나누어 비교 한다.
		System.out.println("str01.contentEquals(str02) : " + str01.contentEquals(str02));
		System.out.println(str01.hashCode()); // 1373385857
		System.out.println(str02.hashCode()); // 1373385857
		
		// 객체의 주소값으로 해시코드를 메서드 호출
		System.out.println(System.identityHashCode(str01)); // 366712642
		System.out.println(System.identityHashCode(str02)); // 1829164700
	}

}
