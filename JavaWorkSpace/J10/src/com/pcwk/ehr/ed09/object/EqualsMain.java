package com.pcwk.ehr.ed09.object;

public class EqualsMain {

	public static void main(String[] args) {
		Person p01 = new Person(1234567890);
		Person p02 = new Person(1234567890);
		
		boolean check = p01.equals(p02);
		System.out.println("p01" + p01);
		System.out.println("p02" + p02);
		System.out.println("check : " + check);
		
	}

}
