package com.pcwk.ehr.ed01.linkedlist;

import java.util.*;

public class Ex01LinkedList {

	// 순차적인 추가
	public static long addSequentail(List<String> list) {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++) {
			list.add(String.valueOf(i));
		}

		long end = System.currentTimeMillis();
		return end - start;
	}

	// 중간에 추가
	public static long addMiddle(List<String> list) {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++) {
//			list.add(String.valueOf(i));
			list.add(99, String.valueOf(i));
		}

		long end = System.currentTimeMillis();
		return end - start;
	}

	// 뒤에서 부터 삭제
	public static long removeList(List<String> list) {
		long start = System.currentTimeMillis();
		// 앞에서부터 삭제하면 안됨
		for (int i = list.size() - 1; i > -0; i--) {
			list.remove(i);
		}

		long end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		// 빈번한 추가 삭제에 유리한 LinkedList
		// ArrayList Vs LinkedList

		// 순차적인 추가
		ArrayList<String> arrayList = new ArrayList<String>(1_000_000);
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println("순차적인 추가");
		System.out.println("ArrayList : " + addSequentail(arrayList));
		System.out.println("LinkedList : " + addSequentail(linkedList));

		// 중간에 추가 삭제
		System.out.println("===========================================");
		System.out.println("중간에 추가 삭제");
//		System.out.println("ArrayList : " + addMiddle(arrayList));
//		System.out.println("LinkedList : " + addMiddle(linkedList));

		// 데이터 삭제
		System.out.println("===========================================");
		System.out.println("데이터 삭제");
		System.out.println("ArrayList : " + removeList(arrayList));
		System.out.println("LinkedList : " + removeList(linkedList));
	}

}
