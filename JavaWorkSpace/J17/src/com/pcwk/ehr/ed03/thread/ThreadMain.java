package com.pcwk.ehr.ed03.thread;

public class ThreadMain {

	public static void main(String[] args) {
		Ex01Thread th01 = new Ex01Thread();
		Ex02Thread th02 = new Ex02Thread();

		th02.setPriority(7);
		System.out.println("th01 priority : " + th01.getPriority());
		System.out.println("th02 priority : " + th02.getPriority());

		th01.start();
		th02.start();
	}

}
