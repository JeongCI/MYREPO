package com.pcwk.ehr.ed06.time;

import java.time.*;

public class Ex08DateVS {

	public static void main(String[] args) {
		// 각 필드 값을 비교하기
		// isAfter()	이전 날짜인지 비교하여 boolean
		// isBefore()	지나간 날짜인지 비교하여 boolean
		// isEqual()	동일 날짜인지 비교하여 boolean
		// between()	날짜의 차이를 반환
		
		LocalDateTime ldt01 = LocalDateTime.of(2010, 1, 1, 12, 23, 23, 555);
		System.out.println("ldt01 : " + ldt01);
		LocalDateTime ldt02 = LocalDateTime.of(2010, 12, 25, 1, 12, 23, 232);
		System.out.println("ldt02 : " + ldt02);
		
		System.out.println(ldt01.isAfter(ldt02)); // ldt01 이 ldt02 보다 이전날짜인가
		System.out.println(ldt01.isBefore(ldt02));// ldt01 이 ldt02 보다 이후날짜인가
		System.out.println(ldt01.isEqual(ldt02)); // ldt01 이 ldt02 와 같은가
	}

}
