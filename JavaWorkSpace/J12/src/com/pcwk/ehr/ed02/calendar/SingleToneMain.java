package com.pcwk.ehr.ed02.calendar;

public class SingleToneMain {

	public static void main(String[] args) {
		SingleTone st01 = SingleTone.getInstnce();
		SingleTone st02 = SingleTone.getInstnce();
		SingleTone st03 = SingleTone.getInstnce();
		
		System.out.println("st01 : " + st01);
		System.out.println("st02 : " + st02);
		System.out.println("st03 : " + st03);
	}

}