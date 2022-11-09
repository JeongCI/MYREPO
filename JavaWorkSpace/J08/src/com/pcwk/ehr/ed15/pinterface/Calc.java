package com.pcwk.ehr.ed15.pinterface;

public interface Calc {
	// public final static 생략가능

	// public final static double PI = 3.14;
	double PI = 3.14;
	int ERROR = 99;

	// public abstract int add(int num1, int num2);
	// public abstract 생략 가능
	/**
	 * 더하기
	 * 
	 * @param num1
	 * @param num2
	 * @return num1 + num2
	 */
	int add(int num1, int num2);

	/**
	 * 빼기
	 * 
	 * @param num1
	 * @param num2
	 * @return num1 - num2
	 */
	int substract(int num1, int num2);

	double divide(double num1, double num2);

	int multiply(int num1, int num2);
	
	//JDK 1.8이후 추가
	static int total(int[] arr) {
		int sum = 0;
		
		for(int num : arr) {
			sum += num;
		}
		return sum;
	}
	
	//JDK 1.8이후 추가
	default void description() {
		System.out.println("정수 계산기를 구현 합니다.");
	}

}
