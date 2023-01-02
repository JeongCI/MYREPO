package com.pcwk.ehr.aspectj.perform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class PerformanceAroundAdvice {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	//성능 측정 메서드(종료 - 시작): 경과시간
	public Object performanceAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		LOG.debug("┌───────────────────────────────────────────┐");
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.stop();
		
		LOG.debug("│method: "+method);
		LOG.debug("│"+stopWatch.getTotalTimeMillis()+"(ms)초");
		LOG.debug("└───────────────────────────────────────────┘");
		
		return returnObj;
	}
}
