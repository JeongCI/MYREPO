package com.pcwk.ehr.ed02.thread;

public class SingleThread {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간1 : " + (endTime - startTime));

		System.out.println();
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("="));
		}
		endTime = System.currentTimeMillis();
		System.out.println("경과시간2 : " + (endTime - startTime));

	}

}
