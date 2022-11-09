package com.pcwk.ehr.ed11.oop2;

public class DrawShapeMain {

	public static void main(String[] args) {
		Point[] p = {
					new Point(100,100),
					new Point(150,50),
					new Point(250,50)
		};
		
		Circle c = new Circle(new Point(50,50),46);
		Triangle t = new Triangle(p);
		
		c.draw();
		t.draw();
		
	}

}
