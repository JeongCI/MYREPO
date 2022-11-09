package com.pcwk.ehr.ed06.enump;

public enum Direction {
	EAST(6), SOUTH(2), WEST(4), NORTH(8);
	
	private final int value; // 정수값을 지정할 필드 
	
	Direction(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
}