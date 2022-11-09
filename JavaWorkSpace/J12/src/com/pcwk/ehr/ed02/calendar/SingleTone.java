package com.pcwk.ehr.ed02.calendar;

public class SingleTone {
	
	private static SingleTone instance;
	
	private SingleTone() {
		// private 생성자는 외부에서 호출 X
	}
	
	public static SingleTone getInstnce() {
		if(instance == null) {
			instance = new SingleTone();
		}
		
		return instance;
	}
}
