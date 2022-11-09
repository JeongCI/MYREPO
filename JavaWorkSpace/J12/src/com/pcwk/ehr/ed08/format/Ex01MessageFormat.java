package com.pcwk.ehr.ed08.format;

import java.text.MessageFormat;
import java.util.*;


public class Ex01MessageFormat {

	public static void main(String[] args) {
		// 고객들에게 보낼 안내문에 받는 사람이름을 달리 보낼 경우에 사용
		String msg = "Name : {0} \nTel : {1} \nAge : {2} \nBirthday : {3}";
		Object[] arguments = {"PCWK","010-1234-5678","23","08/26"};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
	}

}