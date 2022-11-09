package com.pcwk.ehr.ed13.pabstract;

public class PlayerMain {

	public static void main(String[] args) {
		// 추상 클래스는 객체를 스스로 만들 수 없다.
		//Player player = new Player();

		// 상속받은 자식을 통해서 생성.
		Player player = new AudioPlay();
		player.play(3);
		player.stop();
		player.disp();

	}

}
