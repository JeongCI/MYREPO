package com.pcwk.ehr.ed11.oop2;

public class Circle extends Shape {
	
	Point center; // 원의 원점 좌표
	int r; // 반지름
	
	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	public Circle() {
		this(new Point(0,0),50);
	}
	
	void draw() {
		System.out.printf("[center : %d, %d], r : %d, color : %s\n",center.x,center.y,r,color);
	}
	
}
