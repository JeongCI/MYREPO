package com.pcwk.ehr.ed14.pabstract;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		System.out.println("cal.PI : " + cal.PI);
		System.out.println("cal.add : " + cal.add(11, 13));
		System.out.println("cal.substract : " + cal.substract(11, 13));
		System.out.println("cal.divide : " + cal.divide(11, 13));
		System.out.println("cal.mutiply : " + cal.multiply(11, 13));
	}

}
