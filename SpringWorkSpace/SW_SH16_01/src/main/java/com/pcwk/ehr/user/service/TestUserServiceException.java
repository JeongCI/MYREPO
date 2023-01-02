package com.pcwk.ehr.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUserServiceException extends RuntimeException {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	public TestUserServiceException () {}
	
	public TestUserServiceException (String message) {
		super(message);
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│message: "+message);
		LOG.debug("└───────────────────────────────────────────┘");
	}
	
	
}
