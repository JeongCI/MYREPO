package com.pcwk.ehr.ed02.calendar;

import java.util.Calendar;

public class Ex02Calendar {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		// 년도
		int year = today.get(Calendar.YEAR);

		// 월(0 ~ 11) 0 => 1월
		int month = today.get(Calendar.MONTH) + 1;

		// 일
		int day = today.get(Calendar.DATE);

		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		System.out.printf("%d-%02d-%02d", year, month, day);
		System.out.println("=========================");
		// 요일
		int week = today.get(Calendar.DAY_OF_WEEK);
		System.out.println("week : " + week);
		
		// 오전(0), 오후 출력(1)
		System.out.println(today.get(Calendar.AM_PM));
		
		// 시간(0 ~ 11)
		System.out.println(today.get(Calendar.HOUR));
		// 시간(0 ~ 23)
		System.out.println(today.get(Calendar.HOUR_OF_DAY));
		
		// 분(0 ~ 59)
		System.out.println(today.get(Calendar.MINUTE));
		
		// 초(0 ~ 59)
		System.out.println(today.get(Calendar.SECOND));
		
		// 1/1000초
		System.out.println(today.get(Calendar.MILLISECOND));
		
		System.out.println(today.get(Calendar.HOUR_OF_DAY) + " : " + 
				today.get(Calendar.HOUR_OF_DAY) + "시 : " + 
				today.get(Calendar.MINUTE) + "분 : " +
				today.get(Calendar.SECOND) + "." +
				today.get(Calendar.MILLISECOND) + "초");
		
		// 금년에 오늘이 몇일째인가?
		System.out.println("금년에 오늘이 몇일째 : " + today.get(Calendar.DAY_OF_YEAR));
		
	}

}
