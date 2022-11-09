package com.pcwk.ehr.ed02.calendar;

import java.util.Calendar;

public class Ex01Calendar {

	public static void main(String[] args) {
		// 추상클래스로 생성자 통한 객체를 생성할 수 없다.
//		Calendar cal = new Calendar();
		
		// 객체 생성 방법
		Calendar cal01 = Calendar.getInstance();
		Calendar cal02 = Calendar.getInstance();
		
		System.out.println("cal01 : " + cal01.toString());
		System.out.println("cal02 : " + cal02.toString());
		
		// 객체의 동일성 확인
		System.out.println("cal01 : " + cal01.hashCode());
		System.out.println("cal02 : " + cal02.hashCode());
		
		
	}

}
