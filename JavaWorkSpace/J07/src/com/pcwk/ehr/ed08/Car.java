package com.pcwk.ehr.ed08;

public class Car {

	String color; // 색상
	String gearType; // auto/manual
	int door; // 문

	Car() {
		this("white", "auto", 4);
	}

	Car(String color) {
		this(color, "auto", 4);
	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}