package com.pcwk.ehr.ed05;

public class MyDataMain {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		md.setYear(2022);
		md.setMonth(8);
		md.setDay(19);

		System.out.println(md.getYear());
		System.out.println(md.getMonth());
		System.out.println(md.getDay());
		System.out.println(md.toString());
	}

}