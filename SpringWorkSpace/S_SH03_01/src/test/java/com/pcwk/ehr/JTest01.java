package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class JTest01 {
	final Logger LOG = LogManager.getLogger(getClass());
	
	/**
	 * 1. 테스트 메소드에 public
	 * 2. 메소드에 @Test를 붙여준다
	 * 3. return void
	 * 4. 파라메터 사용불가
	 */
	
	@Test
	public void pcwkTest01() {
		LOG.debug("==============");
		LOG.debug("=pcwkTest01=");
		LOG.debug("==============");
	}
	
	private int check() {
		return 0;
	}
	
	//private 사용 불가
	//return void 사용 가능
	@Test
	public void pcwkTest02(int name) {
		LOG.debug("==============");
		LOG.debug("=pcwkTest02=");
		LOG.debug("==============");
		check();
	}
}
