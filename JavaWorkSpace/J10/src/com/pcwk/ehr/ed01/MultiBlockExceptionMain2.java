package com.pcwk.ehr.ed01;

import com.pcwk.ehr.cmn.LoggerManger;

public class MultiBlockExceptionMain2 implements LoggerManger {

	public static void main(String[] args) {
		LOG.debug("1");
		
		int intArray[] = {1,2,0,5};
		try {
			LOG.debug("2");
			LOG.debug(1/intArray[3]); // 예외 발생
			LOG.debug("3"); // 수행되지 않음
			//JDK 1.7이후 부터 가능
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
			if(e instanceof ArithmeticException) {
				LOG.debug("5 ArithmeticException : " + e.getMessage());
			} else if(e instanceof ArrayIndexOutOfBoundsException) {
				LOG.debug("5 ArrayIndexOutOfBoundsException : " + e.getMessage());
			}
		}catch(Exception e) {
			LOG.debug("5 Exception : " + e.getMessage());
		}finally {
			LOG.debug("5.1 funally");
		}
		LOG.debug("6 프로그램 종료");
	}

}