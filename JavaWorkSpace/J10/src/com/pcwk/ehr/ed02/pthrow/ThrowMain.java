package com.pcwk.ehr.ed02.pthrow;

import com.pcwk.ehr.cmn.LoggerManger;

public class ThrowMain implements LoggerManger {
// 프로그래머가 강제로 예외를 발생시킬 수 있다.
// 1. 발생시키려고 하는 예외 클래스 생성.
// 2. 키워드 throw를 이용해서 예외를 발생.
	public static void main(String[] args) {
		LOG.debug("1");

		try {
			Exception e = new Exception("예외 발생 시키기(의도적으로)");
			throw e;
		} catch (Exception ex) {
			LOG.debug("3. 예외 발생");
			LOG.debug("3.1 : " + ex.getMessage());
		}
		LOG.debug("프로그램 종료!");
	}

}