package com.pcwk.ehr.ed09.object.clone2;

public class Point implements Cloneable {
	int x;
	int y;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// JDK 1.5에 추가된
	// 공변환 : 조상 메서드의 변환타입을 자손 클래스의 타입으로 변경을 허용
	public Point clone() {
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (Point)obj;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}