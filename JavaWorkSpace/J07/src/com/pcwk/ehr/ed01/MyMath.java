package com.pcwk.ehr.ed01;

public class MyMath {
	
	/**
	 * 더하기
	 * @param a
	 * @param b
	 * @return
	 */
	long add(long a,long b) {
		long result = 0;
		
		result = a + b;
		
		return result;
	}
	
	/**
	 * 빼기
	 * @param a
	 * @param b
	 * @return
	 */
	long subtract(long a, long b) {
		long result = 0;
		
		result = a - b;
		
		return result;
	}
	
	/**
	 * 곱하기
	 * @param a
	 * @param b
	 * @return
	 */
	long multiply(long a, long b) {
		return a*b;
	}
	
	/**
	 * 나누기
	 * @param a
	 * @param b
	 * @return
	 */
	double divide(double a, double b) {
		return a/b;
	}

}
