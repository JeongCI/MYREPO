package com.pcwk.ehr.ed07;

public class CarThisMain {

	public CarThisMain() {

	}

	public static void main(String[] args) {
		Car car01 = new Car();

		Car car02 = new Car("Black");
//		System.out.println("car01 : "+car01.color + ", " + car01.gearType + ", " + car01.door);

		disp(car01);
		disp(car02);
	}

	public static void disp(Car car) {
		System.out.println("car : " + car.color + ", " + car.gearType + ", " + car.door);

	}

}