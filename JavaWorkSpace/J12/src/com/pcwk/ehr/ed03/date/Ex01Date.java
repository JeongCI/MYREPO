package com.pcwk.ehr.ed03.date;

import java.util.Date;

public class Ex01Date {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println("today : " + today.toString());

		Date todayCurr = new Date(System.currentTimeMillis());
		System.out.println("todayCurr : " + todayCurr.toString());

	}

}