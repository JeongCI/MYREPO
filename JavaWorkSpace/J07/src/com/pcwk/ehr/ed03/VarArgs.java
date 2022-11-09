package com.pcwk.ehr.ed03;

public class VarArgs {
	
	/**
	 * 메서드 가변 인자
	 * @param delim
	 * @param args
	 * @return
	 */
	String concatenate(String delim, String...args) {
		String result = "";
		
		for( String str : args) {
			result += str + delim;
		}
		return result;
	}
	
}
