package com.pcwk.ehr.ed09.object.clone2;

public class PointMain {

	public static void main(String[] args) {
		Point org = new Point(11, 13);

		Point copy = org.clone();

		System.out.println("org : " + org.toString());
		System.out.println("copy : " + copy.toString());
	}

}