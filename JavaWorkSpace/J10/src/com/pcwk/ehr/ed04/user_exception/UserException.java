package com.pcwk.ehr.ed04.user_exception;

import com.pcwk.ehr.cmn.LoggerManger;

public class UserException implements LoggerManger {
	
	
	public static void ticketing(int age) throws KoreaException {
		if(age  < 0) {
			LOG.debug("ticketing() : " + age);
			throw new KoreaException("나이를 확인 하세요.\n나이는 > 0");
		}
	}

	public static void main(String[] args) {
		try {
			ticketing(-9);
		} catch (KoreaException e) {
			LOG.debug("main KoreaException ");
			LOG.debug("getMessage : " + e.getMessage());
		}
	}

}