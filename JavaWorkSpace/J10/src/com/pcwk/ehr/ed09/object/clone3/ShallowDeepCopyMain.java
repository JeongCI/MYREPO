package com.pcwk.ehr.ed09.object.clone3;

public class ShallowDeepCopyMain {

	public static void main(String[] args) {
		Circle c01 = new Circle(new Point(11, 16), 2.5);
		Circle c02 = c01.shallowCopy();
		Circle c03 = c01.deepCopy();

		System.out.println("c01 : " + c01);
		System.out.println("c02 : " + c02);
		System.out.println("c03 : " + c03);

		System.out.println("c01.point 변경 이후");
		c01.point.x = 8;
		c01.point.y = 8;
		System.out.println("c01 : " + c01);
		System.out.println("c02 : " + c02);
		System.out.println("c03 : " + c03);
	}

}