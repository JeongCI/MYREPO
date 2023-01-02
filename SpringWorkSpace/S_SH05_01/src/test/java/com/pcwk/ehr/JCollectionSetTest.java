package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.col.CollectionBean;
import com.pcwk.ehr.col.CollectionSet;

@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = "/applicationContext_CollectionSet.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //메서드 asc순으로 수행
public class JCollectionSetTest {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired //컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 변을 찾고, 변수에 주입
	ApplicationContext context;
	
	//AbstractApplicationContext context;
	CollectionSet collectionSet;
	
   @Before
   public void setUp() throws Exception {
      LOG.debug("------------------------");
      LOG.debug("-setUp()-");
      LOG.debug("------------------------");
      
     // context = new GenericXmlApplicationContext("/applicationContext.xml");
      
      LOG.debug("context: " + context);
      assertNotNull(context);
      
      collectionSet = context.getBean("collectionSet", CollectionSet.class);
      
      LOG.debug("collectionSet: "+ collectionSet);
      assertNotNull(collectionSet);
   }

   @Test
   public void collectionTest() throws Exception {
      LOG.debug("------------------------");
      LOG.debug("-collectionTest()-");
      LOG.debug("------------------------");
      
      Set<String> set = collectionSet.getAddRessSet();
      for(String str : set) {
    	  LOG.debug("str: " + str);
      }
   }

   @After
   public void tearDown() throws Exception {
      LOG.debug("+++++++++++++++++++++++++");
      LOG.debug("-tearDown()-");
      LOG.debug("+++++++++++++++++++++++++");
   }

}
