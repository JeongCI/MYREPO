package com.pcwk.ehr.ed07.time;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {

	public static void main(String[] args) {
		Timer t = new Timer(true); // timer 를 데몬으로 생성

		TimerTask w1 = new Work01();
		TimerTask w2 = new Work02();

		// timer 데몬에 등록
		t.schedule(w1, 2000);
		t.schedule(w2, 2000);

		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}
