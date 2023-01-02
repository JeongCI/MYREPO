package com.pcwk.ehr.aspectj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class LoggingAop {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	public void logging(JoinPoint jointPoint) {
		Signature signature = jointPoint.getSignature();
		
		String methodName = signature.getName(); //메소드 이름
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│methodName: "+methodName                 +"│");
		LOG.debug("└───────────────────────────────────────────┘");		
	}
	
}
