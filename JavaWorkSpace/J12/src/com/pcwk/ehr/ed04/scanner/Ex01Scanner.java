package com.pcwk.ehr.ed04.scanner;

import java.util.Scanner;

public class Ex01Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] argArr = null;

		while (true) {
			System.out.println("q를 입력하면 종료");
			System.out.print(">>");

			// Line단위로 입력
			String input = sc.nextLine();

			// String 앞뒤 공백 제거
			input = input.trim();

			// abc 1234 567
			// regExp : '+' 1회 이상 반복
			argArr = input.split(" +"); // 입력받은 내용을 공백을 구분자로 자른다.

			String command = argArr[0];

			command = command.toLowerCase(); // Q, q -> q 소문자로 변환.
			if ("q".contentEquals(command)) {
				System.out.println("프로그램 종료");
				System.exit(0);
			} else {
				for (String s : argArr) {
					System.out.println(s);
				}
			}
		}
	}

}
