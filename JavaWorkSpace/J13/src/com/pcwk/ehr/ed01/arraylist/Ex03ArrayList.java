package com.pcwk.ehr.ed01.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Ex03ArrayList {

	public static void main(String[] args) {
		ArrayList<String> lectureList = new ArrayList<String>(
				Arrays.asList("C", "JAVA", "DB", "WEB", "SPRING", "EM.linux", "C"));

		// for문
		for (int i = 0; i < lectureList.size(); i++) {
			String delim = ", ";
			if (i == lectureList.size() - 1) {
				delim = "";
			}
			System.out.print(lectureList.get(i) + delim);
		}
		System.out.println();

		// iterator
		Iterator<String> iterator = lectureList.iterator();

		while (iterator.hasNext() == true) { // 데이터가 있으면 true
			// 데이터 출력
			System.out.print(iterator.next() + ", ");
		}
		System.out.println();
	}

}
