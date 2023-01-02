package com.pcwk.ehr.naver;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pcwk.ehr.cmn.SearchVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-test-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebNaverController {
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc  mockMvc;
	
	
	SearchVO search01;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		search01 = new SearchVO(10, 1, "20", "날씨", "");
	}
	
	@Test
	public void doNaverSearch() throws Exception {
		//url, param 설정, 호출방식(get/post)                                                
		MockHttpServletRequestBuilder  requestBuilder= MockMvcRequestBuilders.get("/naver/doNaverSearch.do")
				                                       .param("pageSize", search01.getPageSize()+"")
				                                       .param("pageNo", search01.getPageNo()+"")
				                                       .param("searchDiv", search01.getSearchDiv())
				                                       .param("searchWord", search01.getSearchWord());
		//대역 객체를 통해 호출
		ResultActions resultActions =mockMvc.perform(requestBuilder)
		                                               .andExpect(status().is2xxSuccessful());	
		
		String responseResult =  resultActions.andDo( print() )
			    .andReturn().getResponse().getContentAsString();	
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|responseResult:"+responseResult);
		LOG.debug("└-------------------------------------------┘");	
		
		
	}

	@Test
	public void beans() {
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|webApplicationContext:"+webApplicationContext);
		LOG.debug("|mockMvc:"+mockMvc);	
		LOG.debug("└-------------------------------------------┘");	
		
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
	}

}
