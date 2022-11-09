package com.pcwk.ehr.ed13.pabstract;

// 스스로 객체 생성 불가.
public abstract class Player {
	/**
	 * start
	 * @param pos
	 */
	abstract void play(int pos); // 추상 메서드
	/**
	 * stop
	 */
	abstract void stop(); // 추상 메서드
	
	void disp() {
		System.out.println("야 금요일이다!");
	}

}
