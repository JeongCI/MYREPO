package com.pcwk.ehr.ed06.enump;

public class ExMain {

	public static void main(String[] args) {
		Direction[] directArr = Direction.values();
		
		for(Direction d : directArr) {
			System.out.println(d.name()+","+d.getValue());
		}
		
	}

}
