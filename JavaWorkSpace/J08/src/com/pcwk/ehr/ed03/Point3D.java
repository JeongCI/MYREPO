package com.pcwk.ehr.ed03;

public class Point3D extends Point {

	int z;

	Point3D(int x, int y, int z) {
		super(x, y);
		// super() 삽입되고, default생성자가 호출된다.
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	String getLocation() {
		return "x" + x + ", y : " + y + ", z : " + z;
	}

}
