package com.pcwk.ehr.ed05;

public class MyDate {

	private int day;
	private int month;
	private int year;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public MyDate() {

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		// 데이터의 안정성이 높아 진다.
		if (day < 0 || day > 31)
			return; // 1 ~ 31일 사이만 입력 가능
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 0 || month > 13)
			return; // 1 ~ 12월 사이만 입력 가능
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "MyDate [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}