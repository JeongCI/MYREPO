package com.pcwk.ehr.ed14.pabstract;

public class Calculator implements Calc {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public double divide(double num1, double num2) {
		return num1 / num2;
	}

	@Override
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}

}
