package com.pcwk.ehr.ed11;

import java.lang.*;

public class Tv {

	// 멤버 변수
	// 생성자
	// 멤버 함수
	private boolean power;
	private int channel;

	// 생성자
	public Tv() {
	}

	public void power() {
		power = !power;
	}

	public void channelIp() {
		channel++;
	}

	public void channelDown() {
		channel--;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

}
