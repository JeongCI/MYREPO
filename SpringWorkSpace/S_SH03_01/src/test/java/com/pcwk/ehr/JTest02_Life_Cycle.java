package com.pcwk.ehr;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JTest02_Life_Cycle {
	
	final Logger LOG = LogManager.getLogger(getClass());

	@Before
	public void setUp() throws Exception {
		LOG.debug("<setUp()>");
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("<tearDown()>");
	}

	@Test
	public void test01() {
		LOG.debug("<test01()>");
	}
	
	@Test
	public void test02() {
		LOG.debug("<test02()>");
	}

}
