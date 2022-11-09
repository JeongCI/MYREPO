package com.pcwk.ehr.ed01.thread;

public class ExThread extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // Thread의 이름을 return
		}
	}
}
