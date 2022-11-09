package com.pcwk.ehr.ed06;

public class Car {
	
	String color;		// 색상
	String gearType;	// auto/manual
	int door;			// 문
	
	Car(){}
	Car(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}