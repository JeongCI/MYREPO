package com.pcwk.ehr.ed06.time;

import java.time.LocalDate;

public class Ex04LeepYear {

	public static void main(String[] args) {
		// 윤달 확인
		// 1900 ~ 2100 까지
		LocalDate ld = LocalDate.now();

		LocalDate newLd = null;

		int cnt = 0; // 윤달 건수

		for (int i = 1900; i <= 2100; i++) {
			newLd = ld.withYear(i);
//			System.out.println(newLd);
			if (newLd.isLeapYear() == true) {
				System.out.println(i + "은 윤년 입니다");
				cnt++;
			}
		}
		System.out.println("1900 ~ 2100 까지 윤년의 횟수 : " + cnt + "입니다.");

	}

}