package com.pcwk.ehr.ed07;

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

	Car(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}