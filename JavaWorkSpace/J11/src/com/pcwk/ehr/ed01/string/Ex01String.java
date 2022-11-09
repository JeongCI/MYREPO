package com.pcwk.ehr.ed01.string;

import java.lang.Character.Subset;

public class Ex01String {

	public static void main(String[] args) {
		String fullName = "Hello.java";
		String abc = new String("Hello.java");

		// 왼쪽부터 0, 왼족에서 오른쪽으로 찾는다.
		// 찾는 데이터가 없으면 -1 return
		int idx = fullName.indexOf(".");
		System.out.println("fullName.indexOf(.) : " + idx);

		// 왼쪽부터 0, 왼족에서 오른쪽으로 찾는다.
		idx = fullName.lastIndexOf(".");
		System.out.println("fullName.lastIndexOf(.) : " + idx);

		// substring()
		// 해당위치 부터 문자열을 잘라내기
		// 파일 확장자 찾기
		String ext = fullName.substring(idx + 1);
		System.out.println("fullName.substring(idx+1) : " + ext);

		// 파일명 찾기
		// substring(0, 5) 마지막 문자는 포함하지 않는다.
		String fileName = fullName.substring(0, idx);
		System.out.println("fullName.substring(0, idx) : " + fileName);

	}

}