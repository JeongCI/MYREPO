package com.pcwk.ehr.ed03;

public class VarArgsMain {

	public static void main(String[] args) {
		String[] str = {"100","200","300"};
		
		VarArgs va = new VarArgs();
		
		System.out.println(va.concatenate("-", str));
		System.out.println(va.concatenate("", str));
		
		// 가변 인자에 인자 생략가능
		System.out.println("[" + va.concatenate("") + "]");
		System.out.println("[" + va.concatenate("") + "]");
		
		
	}

}