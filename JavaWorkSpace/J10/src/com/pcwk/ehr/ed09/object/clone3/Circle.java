package com.pcwk.ehr.ed09.object.clone3;

public class Circle implements Cloneable {
	Point point; // 원점
	double r; // 반지름

	public Circle(Point point, double r) {
		super();
		this.point = point;
		this.r = r;
	}

	// 얕은 copy
	public Circle shallowCopy() {
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Circle) obj;
	}

	// deep copy
	public Circle deepCopy() {
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {

		}
		Circle c = (Circle) obj;
		c.point = new Point(this.point.x, this.point.y);

		return c;
	}

	@Override
	public String toString() {
		return "Circle [point=" + point + ", r=" + r + "]";
	}

}
