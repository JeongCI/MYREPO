package com.pcwk.ehr.ed13.pabstract;

public class AudioPlay extends Player{

	@Override
	void play(int pos) {
		System.out.println("play : " + pos);
	}

	@Override
	void stop() {
		System.out.println("stop");
	}

}
