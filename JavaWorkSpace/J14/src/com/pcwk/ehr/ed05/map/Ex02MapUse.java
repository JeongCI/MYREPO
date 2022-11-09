package com.pcwk.ehr.ed05.map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02MapUse {

	// ch형태 value 크기만큼 문자열 처리
	// printBar('#', 3) -> ###
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}

		return new String(bar);
	}

	public static void main(String[] args) {
		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "Z" };

		// 문자열의 빈도수 : A가 몇개, Z 몇개
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < data.length; i++) {
//			System.out.println(data[i]);

			// map에 추가 : data 배열의 데이터를 key로 처리
			// 1. 기존에 key 존재
			if (map.containsKey(data[i])) {
				// 기존 데이터 찾기.
				Integer value = map.get(data[i]);

				map.put(data[i], new Integer(value.intValue() + 1));

				// 2. 기존에 Key 존재 X
			} else {
				map.put(data[i], new Integer(1));
			}

		} // for i

		Iterator iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			Integer value = map.get(key);
			System.out.println(key + ", " + printBar('#', value) + " " + value);
		}

	}

}
//A, ### 3
//D, # 1
//Z, # 1
//K, ##### 5