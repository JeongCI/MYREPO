package com.pcwk.ehr.ed06.time;

import java.time.LocalDate;

public class Ex03With {

	public static void main(String[] args) {
		// with 필드 값을 특정 값으로 변경할 수 있다
		// withYear(int)       년 변경		withHour(int)  시간
		// withMonth(int)      월 변경		withMinute(int) 분
		// withDayOfMonth(int) 일 변경		withSecond(int) 초
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate newDay = today.withDayOfYear(1988)
		.withMonth(8)
		.withDayOfMonth(26);
		System.out.println(newDay);
	}

}