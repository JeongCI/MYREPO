package com.pcwk.ehr.ed01;

public class Ex01TimeMain {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		System.out.println("start : " + start);

		int a = 0;
		for (int i = 1; i < 1_000_000; i++) {
			a++;
		}
		long end = System.currentTimeMillis();

		System.out.println("end : " + end);
		System.out.println("작업 경과 시간:" + (end - start));
	}

}