package com.pcwk.ehr.aspectj;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/pcwk/ehr/aspectj/aspectj_before_applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AspectJBeforeTest {
	
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Member member;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                    bean                   │");
		LOG.debug("└───────────────────────────────────────────┘");	
	}
	
	@Test
	public void AspectJBefore() {
		member.doSave();
		member.doUpdate();
		
		member.delete();
	}

	@Test
	@Ignore
	public void bean() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│context: "+context+"                       │");
		LOG.debug("│member: "+member+"                         │");
		LOG.debug("└───────────────────────────────────────────┘");	
		
		assertNotNull(context);
		assertNotNull(member);
	}

}
