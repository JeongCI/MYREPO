package com.pcwk.ehr.ed04;

public class GenericMethod {

	public static void main(String[] args) {
		Box<Integer> box01 = Util.<Integer>boxing(100);
		
		Box<String> box02 = Util.boxing("점심 맛나게 드세요.");
		
		System.out.println("box01 : " + box01);
		System.out.println("box02 : " + box02);
	}

}
