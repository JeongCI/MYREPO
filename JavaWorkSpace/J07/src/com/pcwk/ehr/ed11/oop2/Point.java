package com.pcwk.ehr.ed11.oop2;

public class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0,0);
	}
	
	public String getXY() {
		return "("+x+","+y+")";
	}
	
	
}
