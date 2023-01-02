package com.pcwk.ehr;

import org.springframework.stereotype.Component;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker () {
		System.out.println("***********************");
		System.out.println("*AppleSpeaker()*");
		System.out.println("***********************");
	}
	@Override
	public void volumeUp() {
		System.out.println("***********************");
		System.out.println("*AppleSpeaker: volumeUp()*");
		System.out.println("***********************");
	}

	@Override
	public void volumeDown() {
		System.out.println("***********************");
		System.out.println("*AppleSpeaker: volumeDown()*");
		System.out.println("***********************");
	}

}
