package com.pcwk.ehr.ed05.enump;

public class ExMain {

	public static void main(String[] args) {
		Direction d01 = Direction.EAST;
		Direction d02 = Direction.valueOf("WEST");
		
		System.out.println("d01 : " + d01);
		System.out.println("d02 : " + d02);
		
		Direction[] directArr = Direction.values();
		
		for(Direction d : directArr) {
			System.out.println(d.name()+", "+d.ordinal());
		}
	}

}
