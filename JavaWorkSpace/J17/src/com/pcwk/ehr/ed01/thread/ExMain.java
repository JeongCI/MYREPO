package com.pcwk.ehr.ed01.thread;

public class ExMain {

	public static void main(String[] args) {
		// Thread 상속
		ExThread t01 = new ExThread();

		// Runnable 인터페이스
		ExRunnable r01 = new ExRunnable();

		Thread t02 = new Thread(r01);

		t01.start();
		t02.start();
	}

}
