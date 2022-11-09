package com.pcwk.ehr.ed05.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex01Map {

	public static void main(String[] args) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		// 추가
		hm.put(1, 1);
		hm.put(2, 1);
		hm.put(3, 2);
		hm.put(3, 4); // key중복시 새로운 데이터가 저장된다. (key는 중복이 허용되지 않는다)

		// 삭제
		hm.remove(3);

		// 값 출력
		System.out.println("get : " + hm.get(1));
		System.out.println("===================");

		// key값 가지고 오기
		Set<Integer> keys = hm.keySet();

		// key -> iterator
		Iterator iter = keys.iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			System.out.println("key : " + key + ", value : " + hm.get(key));
		}
	}

}
