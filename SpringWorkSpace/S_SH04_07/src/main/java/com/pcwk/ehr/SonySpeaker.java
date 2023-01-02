package com.pcwk.ehr;

public class SonySpeaker implements Speaker {
	
	
	public SonySpeaker () {
		System.out.println("====================> SonySpeaker() 객체 생성");
	}
	
	public void volumeUp() {
		System.out.println("====================>SonySpeaker: volumeUp() 소리를 올린다.");
	}
	
	public void volumeDown() {
		System.out.println("====================>SonySpeaker: volumeDown() 소리를 내린다.");
	}
}
