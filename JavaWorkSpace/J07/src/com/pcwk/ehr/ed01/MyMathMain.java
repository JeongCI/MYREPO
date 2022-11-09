package com.pcwk.ehr.ed01;

public class MyMathMain {

	public static void main(String[] args) {
		MyMath myM = new MyMath();

		long result = myM.add(11L, 13L);
		System.out.println("myM.add(11L, 13L) : " + result);

		result = myM.subtract(11L, 13L);
		System.out.println("myM.subtract(11L, 13L) : " + result);

		result = myM.multiply(11L, 13L);
		System.out.println("myM.multiply(11L, 13L) : " + result);

		double result02 = myM.divide(11L, 13L);
		System.out.println("myM.divide(11L, 13L) : " + result02);
	}

}