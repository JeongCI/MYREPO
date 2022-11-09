package com.pcwk.ehr.ed02;

public class MyMathOverload {

	/**
	 * overload 테스트
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	int add(int a, int b) {
		return a + b;
	}

	/**
	 * overload 테스트
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	long add(int a, long b) {
		return a + b;
	}

	/**
	 * overload 테스트
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	long add(long a, long b) {
		return a + b;
	}

	/**
	 * overload 테스트
	 * 
	 * @param a
	 * @return
	 */
	int add(int[] a) {
		int result = 0;

		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}

		return result;
	}

}
