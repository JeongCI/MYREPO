package com.pcwk.ehr.ed02;

public class FruitBox {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();

		Box<Apple> appleBox = new Box<Apple>();
//		Box<Apple> appleBox02 = new Box<Grape>(); 에러 타입 불일치.
		Box<Toy> toyBox = new Box<Toy>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
//		fruitBox.add(new Toy()); 에러 타입 불일치.

		appleBox.add(new Apple());
//		appleBox.add(new Toy()); 에러 타입 불일치

		System.out.println("fruitBox : " + fruitBox);
		System.out.println("appleBox : " + appleBox);
	}

}
