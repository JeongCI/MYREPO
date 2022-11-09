package com.pcwk.ehr.ed06.time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class Ex05WithTemporal {

	public static void main(String[] args) {
		// with TemporalAdjuster 타입을 인자로 받으면 특정한 날짜를 리턴 한다.
		// firstDayOfMonth() 달의 첫번째일
		// lastDayOfMonth() 달의 마지막일
		// firMonth(DayOfWeek dow) 달의 첫번째 요일

		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		LocalDate newLd;

		newLd = ld.with(TemporalAdjusters.firstDayOfYear()); // 년도의 첫번재 일
		System.out.println("년도의 첫번째 일 : " + newLd);

		newLd = ld.with(TemporalAdjusters.lastDayOfYear()); // 년도의 마지막 일
		System.out.println("년도의 마지막 일 : " + newLd);

		newLd = ld.with(TemporalAdjusters.firstDayOfMonth()); // 이번달의 첫번째 일
		System.out.println("이번 달의 첫번째 일 : " + newLd);

		newLd = ld.with(TemporalAdjusters.lastDayOfMonth()); // 이번달의 마지막 일
		System.out.println("이번 달의 마지막 일 : " + newLd);

		newLd = ld.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 이번달의 첫 월요일
		System.out.println("이번 달의 첫 월요일 : " + newLd);

	}

}