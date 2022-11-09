package com.pcwk.ehr.ed06;

import org.apache.log4j.Logger;

public class Log4JTest {
	
	final static Logger LOG = Logger.getLogger(Log4JTest.class);

	public static void main(String[] args) {
		LOG.debug("Hello, world!");
	}

}
