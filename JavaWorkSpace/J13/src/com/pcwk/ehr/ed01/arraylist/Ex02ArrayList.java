package com.pcwk.ehr.ed01.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex02ArrayList {

	public static void main(String[] args) {
		// 삭제시 반드시 마지막 데이터 부터 역순으로 삭제해야 한다.
		ArrayList<String> lectureList = new ArrayList<String>(
				Arrays.asList("C", "JAVA", "DB", "WEB", "SPRING", "EM.linux", "C"));

		System.out.println("lectureList : " + lectureList);

		// 데이터의 삭제
		String removeLec = lectureList.remove(0);
		System.out.println("removeLec : " + removeLec);

		// 데이터 삭제
		lectureList.remove("C");
		System.out.println("lectureList : " + lectureList);

		// 완전삭제
		lectureList.clear();
		System.out.println("lectureList : " + lectureList);
	}

}
