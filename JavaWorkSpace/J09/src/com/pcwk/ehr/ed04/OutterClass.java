package com.pcwk.ehr.ed04;

public class OutterClass {

	int a = 11;
	static int b = 13;

	class Inner {

		int c = 5;

		public void innerMethod() {
			System.out.println("Inner > innerMethod ");
		}
	}

	static class StaticInner {
		int d = 6;
		static int s = 16;

		public static void staticMethod() {
			System.out.println("Static > staticMethod");
		}
	}

}
