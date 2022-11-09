package com.pcwk.ehr.ed02.classz;

public class Tv {

	//속성:변수
	String color;//색상
	boolean power;//전원상태
	public int channel;//채널
	
	
	
	//기능: 메서드
	public void power() {
		power =!power;
	}
	
	public void channelUp() {
		channel++;
	}
	
	public void channelDown() {
		channel--;
	}
	
}
