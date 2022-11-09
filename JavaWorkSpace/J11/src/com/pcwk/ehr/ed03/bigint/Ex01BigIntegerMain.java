package com.pcwk.ehr.ed03.bigint;

import java.math.BigInteger;

public class Ex01BigIntegerMain {

	public static void main(String[] args) {
		BigInteger bInt01 = new BigInteger("123456789000000000000000");
		BigInteger bInt02 = new BigInteger("100");

		// 더하기
		BigInteger add = bInt01.add(bInt02);

		System.out.println("더하기 : " + add.toString());

		// 빼기
		BigInteger sub = bInt01.subtract(bInt02);
		System.out.println("빼기 : " + sub);

		// 곱하기
		BigInteger multi = bInt01.multiply(bInt02);
		System.out.println("곱하기 : " + multi);

		// 나누기
		BigInteger divide = bInt01.divide(bInt02);
		System.out.println("나누기 : " + divide);
	}

}