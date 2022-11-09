package com.pcwk.ehr.ed02;

public class MyMathOverloadMain {

	public static void main(String[] args) {
		MyMathOverload mmo = new MyMathOverload();
		
		System.out.println("mmo.add(11, 13) : " + mmo.add(11, 13));
		System.out.println("mmo.add(11, 13L) : " + mmo.add(11, 13L));
		System.out.println("mmo.add(11L, 13L) : " + mmo.add(11L, 13L));
		
		int age[] = {11, 13, 16};
		
		System.out.println("mm.add(age) : " + mmo.add(age));
	}

}