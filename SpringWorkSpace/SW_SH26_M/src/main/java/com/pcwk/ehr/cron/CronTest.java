package com.pcwk.ehr.cron;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronTest {

	final Logger LOG = LogManager.getLogger(getClass());
	
	public CronTest() {
		
	}
		
	public void test() {
		LOG.debug("=========================");
		LOG.debug("=cron test 10초에 1번씩 출력!=");
		LOG.debug("=========================");
	}
	
	//메서드에 cron설정
	//@Scheduled(cron = "0/5 * * * * *")
	public void test02() {
		LOG.debug("=========================");
		LOG.debug("=cron test 5초에 1번씩 출력!=");
		LOG.debug("=========================");		
	}
	
}
