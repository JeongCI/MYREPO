package com.pcwk.ehr.aspectj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	 final Logger LOG = LogManager.getLogger(getClass());
	 
	 /**
	  * 메소드 앞뒤에서 수행!(트랜잭션 처리)
	  * @param pjp
	  * @return Object
	  * @throws Throwable
	  */
	 public Object aroundLog(ProceedingJoinPoint pjp)throws Throwable{

		 LOG.debug("┌-------------------------------------------┐");
		 LOG.debug("[BEFORE] 메소드 수행전!");
		 
		 String method = pjp.getSignature().getName();
		 
		 Object returnObj = pjp.proceed();
		 
		 LOG.debug("[method] "+method);
		 LOG.debug("[AFTER] 메소드 수행후!");
		 LOG.debug("└-------------------------------------------┘");	
		 return returnObj;
	 }
}
