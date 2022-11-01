package com.pcwk.ehr.cmn;

public class StringUtil {
	
	/**
	 * Null처리
	 * @param input
	 * @param replace
	 * @return
	 */
	public static String nvl(String input, String replace) {
		String retString = "";
		
		retString = (input==null)? replace:input;
		
		return retString.trim();
	}
	
}
