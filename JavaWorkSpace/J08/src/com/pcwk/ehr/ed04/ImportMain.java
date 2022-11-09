package com.pcwk.ehr.ed04;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportMain {

	public static void main(String[] args) {
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a"); // 시:분:초 오전/오후
		
		
		System.out.println("오늘의 날짜는 : " + date.format(today));
		System.out.println("현재 시간 : " + time.format(today));
		
	}

}