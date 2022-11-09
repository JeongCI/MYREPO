package com.pcwk.ehr.ed02.stack;

import java.util.*;

public class Ex01Stack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		// 추가
		stack.push("C");
		stack.push("JAVA");
		stack.push("DB");
		stack.push("WEB");
		stack.push("Spring");

		// 꺼내기
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}

}
