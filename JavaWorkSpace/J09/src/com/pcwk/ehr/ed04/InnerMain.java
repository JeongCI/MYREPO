package com.pcwk.ehr.ed04;

public class InnerMain {

	public static void main(String[] args) {
		OutterClass oc = new OutterClass();
		System.out.println("OuterClass.a : " + oc.a);
		System.out.println("OuterClass.b : " + OutterClass.b);
		
		OutterClass oc02 = new OutterClass();
		
		// 							   인스턴스.new 이너 클래스();
		OutterClass.Inner outerInner = oc02.new Inner();
		System.out.println("outerInner.c : " + outerInner.c);
		outerInner.innerMethod();
		
		// static inner class
		OutterClass.StaticInner sInner = new OutterClass.StaticInner();
		sInner.staticMethod();
		OutterClass.StaticInner.staticMethod();
		
	}

}
