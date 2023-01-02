package com.pcwk.ehr;

import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_LOGIN_COUNT_FOR_SILVER;
import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_RECOMMEND_COUNT_FOR_GOLD;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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

import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //spring-test lib에 있음
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
								  ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebUserController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc mockMvc;
	
	//테스트 픽스처
	List<UserVO> users;
	
	//검색어 사용
	UserVO search;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		users = Arrays.asList(
				 new UserVO("p11_01", "이상무11_01", "4321",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER-1,0,"ckddls13@gmail.com","날짜_사용하지 않음")
				,new UserVO("p11_02", "이상무11_02", "4322",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER,0,"ckddls13@gmail.com","날짜_사용하지 않음")
				,new UserVO("p11_03", "이상무11_03", "4323",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+1,MIN_RECOMMEND_COUNT_FOR_GOLD-1,"ckddls13@gmail.com","날짜_사용하지 않음")
				,new UserVO("p11_04", "이상무11_04", "4324",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+2,MIN_RECOMMEND_COUNT_FOR_GOLD,"ckddls13@gmail.com","날짜_사용하지 않음")
				,new UserVO("p11_05", "이상무11_05", "4325",Level.GOLD,MIN_LOGIN_COUNT_FOR_SILVER+3,35,"ckddls13@gmail.com","날짜_사용하지 않음")
			);
	search = new UserVO("p11", "이상무11", "4321",Level.BASIC,49,0,"jci1203@naver.com","날짜_사용하지 않음");
	}
	
	@Test
	public void doDelete() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/doDelete.do")
														.param("uId", users.get(0).getuId());
		//대역 객체를 통해 호출
		ResultActions resultActions = mockMvc.perform(requestBuilder)
											.andExpect(status().is2xxSuccessful());
		String responseResult = resultActions.andDo(print())
								.andReturn().getResponse().getContentAsString();
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│=responseResult= : " + responseResult);
		LOG.debug("└───────────────────────────────────────────┘");
	}
	
	@Test
	@Ignore
	public void view() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/view.do")
														.param("uId", users.get(0).getuId());
		//대역 객체를 통해 호출
		ResultActions resultActions = mockMvc.perform(requestBuilder)
											.andExpect(status().is2xxSuccessful());
		String responseResult = resultActions.andDo(print())
								.andReturn().getResponse().getContentAsString();
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│=responseResult= : " + responseResult);
		LOG.debug("└───────────────────────────────────────────┘");
	}

	@Test
	public void beans() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│=webApplicationContext= : " + webApplicationContext);
		LOG.debug("│=mockMvc= : " + mockMvc);
		LOG.debug("└───────────────────────────────────────────┘");
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
	}

}
