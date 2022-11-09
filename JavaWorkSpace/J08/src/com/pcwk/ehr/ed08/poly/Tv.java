package com.pcwk.ehr.ed08.poly;

public class Tv {
	boolean power;
	int channel;
	
	void power() {
		power =!power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
}
