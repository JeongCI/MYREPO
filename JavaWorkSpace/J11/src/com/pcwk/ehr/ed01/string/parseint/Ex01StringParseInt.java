package com.pcwk.ehr.ed01.string.parseint;

public class Ex01StringParseInt {

	public static void main(String[] args) {
		// 숫자를 문자로 변환
		int iVal = 100;
		System.out.println("iVal : " + (iVal + 1)); // 문자열 결합

		String strVal = String.valueOf(iVal);

		System.out.println("strVal : " + (strVal + 1)); // 문자열 결합
		System.out.println("====================================");

		double dVal = 200;
		String strVal02 = dVal + "";
		// 문자형 숫자를 숫자로 변환
		double sum = Integer.parseInt(strVal) + Double.parseDouble(strVal02);
		System.out.println("strVal02 : " + (strVal02 + 1));
		System.out.println("sum : " + sum);
	}

}