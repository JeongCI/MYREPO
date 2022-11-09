package com.pcwk.ehr.ed03.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex03DateFormat {

	public static void main(String[] args) {
		SimpleDateFormat sdf01 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		SimpleDateFormat sdf02 = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat sdf03 = new SimpleDateFormat("yy년 MM월 dd일 E요일 a");

		Date today = new Date();

		System.out.println("yyyy/MM/dd HH:mm:ss.SSS : " + sdf01.format(today));
		System.out.println("MM-dd-yyyy : " + sdf02.format(today));
		System.out.println("yy년 MM월 dd일 E요일 a : " + sdf03.format(today));

	}

}
