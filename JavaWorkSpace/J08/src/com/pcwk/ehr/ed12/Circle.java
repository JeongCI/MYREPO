package com.pcwk.ehr.ed12;

public class Circle {
	
	private Point p = new Point(); // 포함 관계
	private int r; // 반지름
	
	public Circle() {
		this(new Point());
	}

	public Circle(Point p) {
		this.p = p;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	

}
