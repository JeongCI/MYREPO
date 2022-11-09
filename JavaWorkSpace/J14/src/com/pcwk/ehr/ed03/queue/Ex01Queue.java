package com.pcwk.ehr.ed03.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01Queue {

	public static void main(String[] args) {
		// Queue(FIFO)
		// Queue interface의 구현체 LinkedList로 객체 생성
		Queue<String> queue = new LinkedList<String>();

		// 추가
		System.out.println(queue.add("C"));
		queue.add("JAVA");
		queue.add("ORACLE");
		queue.add("WEB");
		queue.add("SPRING");
		queue.add("LINUX");
		System.out.println(queue.toString());

		// 삭제
		System.out.println(queue.remove("LINUX"));
		System.out.println(queue.toString());

		// queue의 전체 데이터 다루기
		Iterator<String> iter = queue.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next() + ",");
		}

	}

}
