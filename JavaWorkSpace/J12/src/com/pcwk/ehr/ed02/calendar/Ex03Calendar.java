package com.pcwk.ehr.ed02.calendar;

import java.util.Calendar;

public class Ex03Calendar {

	public static void main(String[] args) {
		// String[] args 통한 입력
//		if (args.length != 2) {
//			System.out.println("사용방법 : 2022 8");
//			System.exit(0);
//		}

		// param 입력 : c:\Users\ITSC>java Ex03Calendar 2022 8
		// param
		for (String str : args) {
			System.out.println(str);
		}

		// 년월 을 숫자로 변환
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);

		int start_day_of_week = 0; // 시작요일
		int end_day = 0; // 월의 마지막 일

		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 종료일

		// set()으로 날짜 지정하기
		// 파람2개.
		// 첫 번째 파라미터는 바꿔야할 항목, 두 번째는 바꿀 값.
		// set(바꿔야할 항목, 값);

		// sDay : 그 달의 시작일
		// eDay : 그 다음달의 시작일
		sDay.set(year, month - 1, 1); // 2022 08 01
		eDay.set(year, month, 1); // 2022 09 01


		eDay.add(Calendar.DATE, -1); // 2022 08 31

		// 시작요일
		start_day_of_week = sDay.get(Calendar.DAY_OF_WEEK);

		// 월의 마지막일
		end_day = eDay.get(Calendar.DATE);

		System.out.printf("%d년%02d월\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");

		// __ 출력 : 시작요일 이전
		for (int i = 1; i < start_day_of_week; i++) {
			System.out.printf("___"); // 3 underscore
		}

		// Date 출력
		for (int i = 1, n = start_day_of_week; i <= end_day; i++, n++) {
			// 1자리, 2자리 구분
			System.out.printf((i < 10) ? "  " + i : " " + i);
			if (n % 7 == 0) {
				System.out.println();
			}
		}

	}

	// 년 월 일
	public static String toString(Calendar today) {
		return today.get(Calendar.YEAR) + "년" + (today.get(Calendar.MONTH + 1)) + "월" + today.get(Calendar.DATE) + "일";
	}

}