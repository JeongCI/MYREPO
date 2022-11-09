package com.pcwk.ehr.ed01.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Ex01ArrayList {

	public static void main(String[] args) {
//		ArrayList arr01 = new ArrayList(10);
		List<String> arr01 = new ArrayList<String>();

		arr01.add("C");
		arr01.add("JAVA");
		arr01.add("DB");
		System.out.printf("초기상태 : ");
		System.out.println(arr01);

		System.out.printf("인덱스 1 위치에 B 추가 : ");
		arr01.add(1, "B");
		System.out.println(arr01);

		System.out.printf("인덱스2 위치의 값 삭제 : ");
		arr01.remove(2);
		System.out.println(arr01);

		System.out.println("인덱스 2번 위치의 값 반환 : " + arr01.get(2));

	}
}
