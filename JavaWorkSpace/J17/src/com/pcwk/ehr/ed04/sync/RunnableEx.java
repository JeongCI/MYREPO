package com.pcwk.ehr.ed04.sync;

public class RunnableEx implements Runnable {
	Account acc = new Account();

	@Override
	public void run() {
		while (acc.getBalance() > 0) {
			// 100, 200, 300
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withDraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}
}
