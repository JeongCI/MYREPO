package com.pcwk.ehr.ed06.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Ex07TimeCal {

	public static void main(String[] args) {
		// String[] args 통한 입력
		if (args.length != 2) {
			System.out.println("사용방법 : 2022 8");
			System.exit(0);
		}
		
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		
		LocalDate ld = LocalDate.of(year, month, 1);
		LocalDate newLd = null;
		System.out.println("ld : " + ld);
		
		int start_day; // 시작일
		int start_day_of_week; // 시작요일
		int end_day; // 월의 마지막 일
		
		newLd = ld.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("newLD : " + newLd);
		
		start_day = ld.getDayOfMonth();
		end_day = newLd.getDayOfMonth();
		System.out.println("start_day : " + start_day);
		System.out.println("end_day : " + end_day);
		
		
		DayOfWeek dayWeek = ld.getDayOfWeek();
		// 시작요일 int
		start_day_of_week = dayWeek.getValue();
		start_day_of_week = (start_day_of_week+1)%7;
		
		// OLD						NEW
		// SU MO TU WE TH FR SA		SU MO TU WE TH FR SA
		// 1  2  3  4  5  6  7		7  1  2  3  4  5  6
		
	}

}
