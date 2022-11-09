package com.pcwk.ehr.ed15.pinterface;

public class CalculatorMain {

	public static void main(String[] args) {
		// interface의 구현체 통한 객체 생성
		Calc cal = new Calculator();
		
		System.out.println("cal.PI : " + cal.PI);
		System.out.println("cal.add : " + cal.add(11, 13));
		System.out.println("cal.substract : " + cal.substract(11, 13));
		System.out.println("cal.divide : " + cal.divide(11, 13));
		System.out.println("cal.mutiply : " + cal.multiply(11, 13));
		
		System.out.println("====================================");
		// default 메서드
		//JDK 1.8이후 추가
		cal.description();
		
		// static 메서드
		//JDK 1.8이후 추가
		int arr[] = {1,2,3,4,5};
		System.out.println(Calc.total(arr));
	}

}
