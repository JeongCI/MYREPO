package com.pcwk.ehr.ed01.thread;

public class ExRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			// 현재 실행 중인 쓰레드의 이름 출력
			System.out.println(Thread.currentThread().getName());
		}

	}

}
