package com.pcwk.ehr.ed01;

public class Ex02Box {

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.setItem("abc");
//		box.setItem(new Object()); String 이외 타입은 지정 불가.

		String item = box.getItem(); // 형변환 필요 없음
	}

}
