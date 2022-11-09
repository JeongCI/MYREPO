package com.pcwk.ehr.ed02.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class Ex02Stack {

	public static void main(String[] args) {
		// ((11+13)*1)+3

		if (args.length != 1) {
			System.out.println("입력 : \"((11+13)*1)+3\"");
			System.exit(0);
		}

		System.out.println("args[0] : " + args[0]);
		String expression = args[0];

		Stack<Character> st = new Stack<Character>();
		try {
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				System.out.println("ch : " + ch);

				// '(' stack 추가
				// ')' stack에서 삭제

				if ('(' == ch) {
					st.add(ch);
				} else if (')' == ch) {
					st.pop();
				}
			}
			// stack이 비어 있으면 가로 일치
			if (st.empty() == true) {
				System.out.println("가로일치");
			} else {
				System.out.println("가로 불일치");
			}
		} catch (EmptyStackException e) {
			System.out.println("가로 불일치");
		}
	}

}
