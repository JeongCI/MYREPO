package com.pcwk.ehr.ed03.wrapper;

import com.pcwk.ehr.cmn.LoggerManger;

public class Ex01WrapperMain implements LoggerManger {

	public static void main(String[] args) {
		// 래퍼 클래스 -> 기본 자료형으로 변환
		Integer iValue = new Integer(100);

		int myInt = iValue.intValue();
		System.out.println("myInt : " + (myInt + 1));

		// int형 String을 기본자료형으로 변환
		String num01String = "100";
		int num01 = Integer.parseInt(num01String);
		System.out.println("num01 + 1 : " + (num01 + 1));

		System.out.println("Integer.MIN_VALUE : " + Integer.MIN_VALUE);
		System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE);
		System.out.println("Integer bit : " + Integer.SIZE + "bit");
		System.out.println("Integer byte : " + Integer.BYTES + "byte");

		System.out.println("========================================");

		System.out.println("Double.MIN_VALUE : " + Double.MIN_VALUE);
		System.out.println("Double.MAX_VALUE : " + Double.MAX_VALUE);
		System.out.println("Double bit : " + Double.SIZE + "bit");
		System.out.println("Double byte : " + Double.BYTES + "byte");
	}

}