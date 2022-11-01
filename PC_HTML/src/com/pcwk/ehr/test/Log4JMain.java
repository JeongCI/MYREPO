package com.pcwk.ehr.test;

import org.apache.log4j.Logger;

public class Log4JMain {
	final static Logger LOG = Logger.getLogger(Log4JMain.class);
	public static void main(String[] args) {
		LOG.debug("Hello, World!");
	}

}
