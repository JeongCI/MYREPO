package com.pcwk.ehr.ed07.enump;

public class ExMain {

	public static void main(String[] args) {
		TrueFalse t01 = TrueFalse.Y;
		TrueFalse t02 = TrueFalse.N;
		
		System.out.println("t01: " + t01.getValue());
		System.out.println("t02: " + t02.getValue());
		System.out.println("t01: " + t01.isSymbol());
		System.out.println("t02: " + t02.isSymbol());
		
		TrueFalse[] trueFalse = TrueFalse.values();
		
		for(TrueFalse tf : trueFalse) {
			System.out.println(tf.getValue() + "=" +  tf.toString());
		}
	}

}
