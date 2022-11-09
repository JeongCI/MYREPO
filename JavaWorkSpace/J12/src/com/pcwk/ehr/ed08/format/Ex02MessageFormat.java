package com.pcwk.ehr.ed08.format;

import java.text.MessageFormat;

public class Ex02MessageFormat {

	public static void main(String[] args) {
		String tableName = "member";
		String msg = "INSERT INTO " + tableName 
				+ " VALUES(''{0}'', ''{1}'', ''{2}'', ''{3}'');";
		
		Object[][] arguments = {
								{"PCWK","010-1234-5678","23","08/26"},
								{"PCWK01","010-1234-5678","23","08/27"}
								};
		for(int i = 0; i < arguments.length; i++) {
			String result = MessageFormat.format(msg, arguments[i]);
			System.out.println(result);
		}
	}

}
