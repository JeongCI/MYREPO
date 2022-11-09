package com.pcwk.ehr.ed06.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex02DateTimeGet {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();

		System.out.println("=========================");
		System.out.println("today : " + today);

		// 년, 월, 일 : getxxx
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();

		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		System.out.println("=========================");

		LocalTime time = LocalTime.now();
		// 시, 분, 초 : getXX
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();

		System.out.println("time : " + time);
		System.out.println("hour : " + hour);
		System.out.println("minute : " + minute);
		System.out.println("second : " + second);

		// zone
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = LocalDate.now().atStartOfDay(zid);
		System.out.println("ZonedDateTime : " + zdt);

		// 현재 시간대의 뉴욕
		ZoneId nyzid = ZoneId.of("America/New_york");
		ZonedDateTime nyZdt = ZonedDateTime.now().withZoneSameInstant(nyzid);
		System.out.println("nyZdt : " + nyZdt);

	}

}
