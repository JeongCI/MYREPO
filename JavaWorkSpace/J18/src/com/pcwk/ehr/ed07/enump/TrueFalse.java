package com.pcwk.ehr.ed07.enump;

public enum TrueFalse {
	
	Y(1, true),N(0,false);
	
	private final int value;
	private final boolean symbol;
	TrueFalse(int value, boolean symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	public int getValue() {
		return value;
	}
	public boolean isSymbol() {
		return symbol;
	}
	public String toString() {
		return name()+","+isSymbol();
	}
}
