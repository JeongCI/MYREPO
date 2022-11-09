package com.pcwk.ehr.ed01.string.equals;

public class EqualsMain {

	public static void main(String[] args) {
		String str01 = "aaa";
		String str02 = "aaa";

		System.out.println("str01 : " + str01);
		System.out.println("str02 : " + str02);
		// 사용 금지
		System.out.println("str01 == str02? " + (str01 == str02));
		System.out.println("str01 == str02? " + str01.equals(str02));

		String str03 = new String("aaa");
		String str04 = new String("aaa");

		System.out.println("str03 == str04? " + (str03 == str04));
		System.out.println("str03 == str04? " + str03.equals(str04));
	}

}