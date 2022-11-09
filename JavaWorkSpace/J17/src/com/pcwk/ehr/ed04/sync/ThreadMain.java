package com.pcwk.ehr.ed04.sync;

public class ThreadMain {

	public static void main(String[] args) {
		RunnableEx r = new RunnableEx();

		new Thread(r).start();
		new Thread(r).start();
	}

}
