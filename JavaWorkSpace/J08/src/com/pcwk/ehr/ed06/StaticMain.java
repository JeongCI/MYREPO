package com.pcwk.ehr.ed06;

public class StaticMain {

	public static void main(String[] args) {
		StaticPractice.say();

		System.out.println("num : " + StaticPractice.num);

		System.out.println("============================");

		StaticPractice sp = new StaticPractice();

	}

}