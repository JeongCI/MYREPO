package com.pcwk.ehr.ed01.string.join;

import java.util.StringJoiner;

public class Ex01StringJoinMain {

	public static void main(String[] args) {
		// String join, StringJoiner
		
		String animals = "dog,cat,bear";
		
		// 기준 문자열 기준으로 짤라 배열을 돌려준다.
		String[] strArr = animals.split(",");
		
		for(String s : strArr) {
			System.out.println(s);
		}
		
		// String배열을 구분자(-)로 결합
		System.out.println(String.join("-", strArr));
		
		StringJoiner sj = new StringJoiner("/", "{", "}");
		
		for(String s : strArr) {
			sj.add(s);
		}
		
		System.out.println(sj.toString()); // {dog/cat/bear}
		
	}

}