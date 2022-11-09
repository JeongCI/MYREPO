package com.pcwk.ehr.ed03.pthrows;

import com.pcwk.ehr.cmn.LoggerManger;

public class ThrowsMain implements LoggerManger {
// 예외던지기(throws)
// 예외던지기란 예외가 발생했을 경우 현재 메서드가 예외를 처리하지 않고
// 자신을 호출한 쪽으로 예외 처리에 대한 책임을 넘기는 것.
	
	public static void methodPcwk() throws Exception {
		LOG.debug("methodPcwk()");
		Exception e = new Exception("methodPcwk 예외 발생");
		throw e;
	}
	
	public static void main(String[] args) {
		LOG.debug("1 ================");
		try {
			methodPcwk();
		} catch (Exception e) {
			LOG.debug("Exception : " + e.getMessage());
		}
		LOG.debug("2 End=============");
	}

}