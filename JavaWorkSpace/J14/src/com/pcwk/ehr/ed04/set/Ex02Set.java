package com.pcwk.ehr.ed04.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex02Set {

	public static void main(String[] args) {
		Set set = new HashSet();

		// 1 ~ 45 random 숫자
		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1; // 0.0 <= x < 1.0 -> 0.0 <= x < 45.0 - > 1<= x < 46
			System.out.println("num : " + num);
			set.add(num);
		}
		System.out.println("set : " + set);
		System.out.println(set);
		List list = new ArrayList(set);

		// asc 소팅
		Collections.sort(list);
		System.out.println(list);

	}

}
