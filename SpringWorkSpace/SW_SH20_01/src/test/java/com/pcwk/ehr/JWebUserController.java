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
import org.mockito.plugins.MockMaker;
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

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebUserController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc  mockMvc;
	
	//테스트 픽스처
	List<UserVO> users;
	
	//
	@Autowired
	UserDao  dao;
	
	//검색에 사용
	UserVO search;
	
	//회원검색
	SearchVO searchVO;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		users = Arrays.asList(
				 new UserVO("p11_01", "이상무11_01", "4321",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER-1,0,"jci1203@naver.com","날짜_사용하지 않음")
				,new UserVO("p11_02", "이상무11_02", "4322",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER,0,"jci1203@naver.com","날짜_사용하지 않음") 
				,new UserVO("p11_03", "이상무11_03", "4323",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+1,MIN_RECOMMEND_COUNT_FOR_GOLD-1,"jci1203@naver.com","날짜_사용하지 않음")
				,new UserVO("p11_04", "이상무11_04", "4324",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+2,MIN_RECOMMEND_COUNT_FOR_GOLD,"jci1203@naver.com","날짜_사용하지 않음")
				,new UserVO("p11_05", "이상무11_05", "4325",Level.GOLD,MIN_LOGIN_COUNT_FOR_SILVER+3,35,"jci1203@naver.com","날짜_사용하지 않음")
				);
		search = new UserVO("p11", "이상무11_01", "4321",Level.BASIC,49,0,"jci1203@naver.com","날짜_사용하지 않음");
		
		searchVO=new SearchVO(10, 1, "", "","");
	}

	@Test
	public void doRetrive() throws Exception{
		//url, param 설정, 호출방식(get/post)
		MockHttpServletRequestBuilder  requestBuilder= MockMvcRequestBuilders.get("/user/doRetrive.do")
				                                       .param("pageSize", searchVO.getPageSize()+"")
				                                       .param("pageNo", searchVO.getPageNo()+"")
				                                       .param("searchDiv", searchVO.getSearchDiv())
				                                       .param("searchWord", searchVO.getSearchWord());
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
	public void doSelectOne() throws Exception{
		//url, param 설정, 호출방식(get/post)
		MockHttpServletRequestBuilder  requestBuilder= MockMvcRequestBuilders.get("/user/doSelectOne.do")
				                                       .param("uId", users.get(0).getuId());	
		
		//대역 객체를 통해 호출
		ResultActions resultActions =mockMvc.perform(requestBuilder)
		                                               .andExpect(status().is2xxSuccessful());	
		
		String responseResult =  resultActions.andDo( print() )
			    .andReturn().getResponse().getContentAsString();	
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|responseResult:"+responseResult);
		LOG.debug("└-------------------------------------------┘");		
		
		UserVO outVO = new Gson().fromJson(responseResult, UserVO.class);
		assertEquals(outVO.getuId(), users.get(0).getuId());
	}
	
	@Test
	@Ignore
	public void addAndGet()throws Exception{
		//1.기존 데이터 삭제
		doDelete(users.get(0));
		doDelete(users.get(1));
		doDelete(users.get(2));
		doDelete(users.get(3));
		doDelete(users.get(4));
		
		//2.신규등록
		add(users.get(0));
		List<UserVO> list = dao.getAll(search);
		assertEquals(1, dao.getCount(search));
		isSameUser(users.get(0), list.get(0));
		
		
		add(users.get(1));
		list = dao.getAll(search);
		assertEquals(2, dao.getCount(search));
		isSameUser(users.get(1), list.get(1));
		
		add(users.get(2));
		list = dao.getAll(search);
		assertEquals(3, dao.getCount(search));
		isSameUser(users.get(2), list.get(2));		
		
	}
	
	public void isSameUser(UserVO actUser, UserVO addUser) {
		assertEquals(actUser.getuId(), addUser.getuId());
		assertEquals(actUser.getName(), addUser.getName());
		assertEquals(actUser.getPasswd(), addUser.getPasswd());
	
		assertEquals(actUser.getLevel(), addUser.getLevel());
		assertEquals(actUser.getLogin(), addUser.getLogin());
		assertEquals(actUser.getRecommend(), addUser.getRecommend());
		assertEquals(actUser.getEmail(), addUser.getEmail());
	}	
	
	@Test
	public void doUpdate()throws Exception{
		//url:/user/add.do, param 설정, 
		//호출방식(post)
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/doUpdate.do")
													.param("uId",       users.get(0).getuId())
													.param("name",      users.get(0).getName())
													.param("passwd",    users.get(0).getPasswd())
													.param("intLevel",  users.get(0).getIntLevel()+"")
													.param("login",     users.get(0).getLogin()+"")
													.param("recommend", users.get(0).getRecommend()+"")
													.param("email",     users.get(0).getEmail());	
		//웹 상태값:200
		//호출 성공
		ResultActions  resultActions  = mockMvc.perform(requestBuilder)
				                        .andExpect(status().isOk());		
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|result="+result);		
		LOG.debug("└=============================┘");
		
		MessageVO messageVO=new Gson().fromJson(result, MessageVO.class);
		assertEquals("1", messageVO.getMsgId());
		
	}
	
	
	//신규등록
	public void add(UserVO inVO)throws Exception{
		//url:/user/add.do, param 설정, 
		//호출방식(post)
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/add.do")
													.param("uId",       inVO.getuId())
													.param("name",      inVO.getName())
													.param("passwd",    inVO.getPasswd())
													.param("intLevel",  inVO.getIntLevel()+"")
													.param("login",     inVO.getLogin()+"")
													.param("recommend", inVO.getRecommend()+"")
													.param("email",     inVO.getEmail());
		//웹 상태값:200
		//호출 성공
		ResultActions  resultActions  = 
				mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
		
		String result = 
				resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("┌=============================┐");	
		LOG.debug("|result="+result);		
		LOG.debug("└=============================┘");
		
		MessageVO messageVO=new Gson().fromJson(result, MessageVO.class);
		assertEquals("1", messageVO.getMsgId());
	}
	
	//삭제
	public void doDelete(UserVO inVO)throws Exception{
		//url, param 설정, 호출방식(get/post)
		MockHttpServletRequestBuilder  requestBuilder= MockMvcRequestBuilders.get("/user/doDelete.do")
				                                       .param("uId", inVO.getuId());
		
		//대역 객체를 통해 호출
		ResultActions resultActions =mockMvc.perform(requestBuilder)
		                                               .andExpect(status().is2xxSuccessful());
		
		String responseResult =  resultActions.andDo( print() )
		    .andReturn().getResponse().getContentAsString();
		//{"msgId":"1","msgContents":"p11_02가 삭제 되었습니다.","totalCnt":0,"num":0}
		
		MessageVO  messageVO= new Gson().fromJson(responseResult, MessageVO.class);
		
		//assertEquals("1", messageVO.getMsgId());
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|responseResult:"+responseResult);
		LOG.debug("└-------------------------------------------┘");			
		
	}
	
	@Test
	public void view()throws Exception{
		//url, param 설정, 호출방식(get/post)
		MockHttpServletRequestBuilder  requestBuilder= MockMvcRequestBuilders.get("/user/view.do")
				                                       .param("uId", users.get(0).getuId());
		
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
		LOG.debug("|dao:"+dao);
		LOG.debug("└-------------------------------------------┘");		
		
		assertNotNull(dao);
		assertNotNull(mockMvc);
		assertNotNull(webApplicationContext);		
	}

}
