package com.pcwk.ehr.ed01;

import com.pcwk.ehr.cmn.LoggerManger;

public class MultiBlockExceptionMain implements LoggerManger {

	public static void main(String[] args) {
		LOG.debug("1");
		
		int intArray[] = {1,2,0,5};
		try {
			LOG.debug("2");
			LOG.debug(1/intArray[2]); // 예외 발생
			LOG.debug("3"); // 수행되지 않음
		}catch(ArithmeticException e) {
			LOG.debug("5 ArithmeticException : " + e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			LOG.debug("5 ArrayIndexOutOfBoundsException : " + e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			LOG.debug("5 Exception : " + e.getMessage());
		}
		LOG.debug("6 프로그램 종료");
	}

}