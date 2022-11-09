package com.pcwk.ehr.ed03.date;

import java.util.Calendar;
import java.util.Date;

import com.pcwk.ehr.cmn.LoggerManger;

public class Ex02DateCalLong implements LoggerManger {

	public static void main(String[] args) {
		// Calendar통해 Date생성
		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());

		System.out.println("today : " + today);

		// Date통해 Calnedar생성
		Date today02 = new Date();
		Calendar cal02 = Calendar.getInstance();

		cal02.setTime(today02);
		System.out.println("today02 : " + today02);
		System.out.println("cal02 : " + cal02);

	}

}
