package com.pcwk.ehr.ed06;

public class CarMain {

	public static void main(String[] args) {
		Car car01 = new Car();
		
		car01.color = "White";
		car01.gearType = "auto";
		car01.door = 4;
		
		System.out.print("car01의 색상 :  " + car01.color);
		System.out.print("\tcar01의 기어 :  " + car01.gearType);
		System.out.print("\tcar01의 문 :  " + car01.door);
		
		System.out.println();
		
		Car car02 = new Car("검정","auto",4);
		System.out.print("car02의 색상 :  " + car02.color);
		System.out.print("\tcar02의 기어 :  " + car02.gearType);
		System.out.print("\tcar02의 문 :  " + car02.door);
	}

}