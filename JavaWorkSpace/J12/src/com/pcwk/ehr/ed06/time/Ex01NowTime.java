package com.pcwk.ehr.ed06.time;
import java.time.*;

public class Ex01NowTime {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		
		System.out.println("today : " + today);
		System.out.println("time : " + time);
		System.out.println("==============================");
		
		LocalDate birthDate = LocalDate.of(1996, 12, 3);
		LocalTime birthTime = LocalTime.of(23, 59, 59);
		System.out.println("birthDate : " + birthDate);
		System.out.println("birthTime : " + birthTime);
		System.out.println("==============================");
		
		LocalDate changeDate = today.minusYears(2) // 2년 빼기
							   .plusMonths(3) // 3개월 더하기
							   .minusDays(5) // 5일 빼기
							   ;
		
		System.out.println("changeDate : " + changeDate);
		System.out.println("==============================");
		
		LocalDate changeWeek = today.plusWeeks(1);
		System.out.println("changeWeek : " + changeWeek);
	}
}