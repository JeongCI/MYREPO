package com.pcwk.ehr.naver;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.naver.service.NaverSearchService;

@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-test-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebNaverSearchService {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값으 주입된다.
	ApplicationContext context;
	
	@Autowired
	NaverSearchService naverSearchService;
	
	SearchVO  search01;
	
	@Before
	public void setUp() throws Exception {
		search01 = new SearchVO(10, 1, "50", "날씨", "");
	}

	@Test
	public void doNaverSearch() {
		try {
		String json	=naverSearchService.doNaverSearch(search01);
		LOG.debug("json:"+json);	
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void beans() {
		LOG.debug("==============================");
		LOG.debug("context:"+context);	
		LOG.debug("naverSearchService:"+naverSearchService);	
		LOG.debug("==============================");
		assertNotNull(context);
		assertNotNull(naverSearchService);
	}

}
