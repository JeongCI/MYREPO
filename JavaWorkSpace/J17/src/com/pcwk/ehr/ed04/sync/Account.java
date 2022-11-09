package com.pcwk.ehr.ed04.sync;

public class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public synchronized void withDraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}

}
