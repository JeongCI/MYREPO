package com.pcwk.ehr.aspectj;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.aspectj.perform.PerformanceAroundAdvice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/pcwk/ehr/aspectj/aspectj_around_applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JAspectAroundTest {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Member member;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void aroundAspect() {
		member.doSave();
		member.doUpdate();
		member.doRetrieve(27);
	}

	@Test
	public void bean() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│bean");
		LOG.debug("│context : "+context);
		LOG.debug("│member : "+member);
		LOG.debug("└───────────────────────────────────────────┘");
		
		assertNotNull(context);
		assertNotNull(member);
	}

}
