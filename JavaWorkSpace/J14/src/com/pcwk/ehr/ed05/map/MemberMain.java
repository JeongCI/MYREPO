package com.pcwk.ehr.ed05.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {

		Map<Integer, Member> map = new HashMap();

		Member member01 = new Member(1, "오일남");
		Member member02 = new Member(67, "강새벽");
		Member member03 = new Member(101, "장덕수");
		Member member04 = new Member(199, "알리압둘");
		Member member05 = new Member(456, "성기훈");

		// 추가 <key 번호 , value : 이름>
		map.put(member01.getMemberId(), member01);
		map.put(member02.getMemberId(), member02);
		map.put(member03.getMemberId(), member03);
		map.put(member04.getMemberId(), member04);
		map.put(member05.getMemberId(), member05);

		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			System.out.println(map.get(iter.next()));
		}

	}

}
