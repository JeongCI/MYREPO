package com.pcwk.ehr.ed03.thread;

public class Ex02Thread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.printf("|");
			for (int x = 0; x < 1000000; x++)
				;
		}
	}
}
