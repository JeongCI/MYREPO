package com.pcwk.ehr.ed03;

public class ExMain {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		// Fruit와 Eatable을 상속받지 않으면 추가가 안됨.
//		FruitBox<Toy> toyBox = new FruitBox<Toy>(); 에러 타입 불일치.

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		fruitBox.add(new Fruit());
		System.out.println("friutbox : " + fruitBox);

		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); 에러 타입 불일치
		System.out.println("applebox : " + appleBox);
	}

}
