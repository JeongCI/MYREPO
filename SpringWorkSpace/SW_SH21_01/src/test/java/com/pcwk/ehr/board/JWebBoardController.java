package com.pcwk.ehr.board;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pcwk.ehr.board.dao.BoardDao;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.user.domain.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebBoardController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc  mockMvc;
	
	@Autowired
	BoardDao  dao;
	
	//테스트 데이터(픽스처)
	List<BoardVO> boards;
	
	SearchVO  searchVO;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		boards = Arrays.asList(
					 new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-11_01", "10", "제목_01", "내용_01", 0, "", "admin", "", "admin")
					,new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-11_02", "20", "제목_02", "내용_02", 1, "", "admin", "", "admin")
					,new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-11_03", "10", "제목_03", "내용_03", 2, "", "admin", "", "admin")
					,new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-11_04", "10", "제목_04", "내용_04", 3, "", "admin", "", "admin")
					,new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-11_05", "10", "제목_05", "내용_05", 4, "", "admin", "", "admin")		
				);
		
		searchVO = new SearchVO(10, 1, "", "", "10");
	}

	public void isSameBoard(BoardVO actBoard, BoardVO addBoard) {
		assertEquals(actBoard.getSeq(), addBoard.getSeq());
		assertEquals(actBoard.getTitle(), addBoard.getTitle());
		assertEquals(actBoard.getContents(), addBoard.getContents());
		//assertEquals(actBoard.getReadCnt(), addBoard.getReadCnt());
		assertEquals(actBoard.getModId(), addBoard.getModId());
		assertEquals(actBoard.getRegId(), addBoard.getRegId());
	}
	@Test
	//@Ignore
	public void doSelectOne()throws Exception{
		//url, param, 호출방식
		MockHttpServletRequestBuilder requestBuilder 
			= MockMvcRequestBuilders.get("/board/doSelectOne.do")
				.param("seq", boards.get(0).getSeq());
		
		
		ResultActions  resultActions  = 
				mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		ModelAndView mav = 
				resultActions.andDo(print()).andReturn().getModelAndView();
		
		
		Map<String, Object> model =mav.getModel();
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|model="+model);		
		LOG.debug("└=============================┘");			
		
		isSameBoard((BoardVO)model.get("vo"),boards.get(0));
	}
	
	@Test
	@Ignore
	public void doUpdate()throws Exception{
		//url, param, 호출방식
		MockHttpServletRequestBuilder requestBuilder 
			= MockMvcRequestBuilders.post("/board/doUpdate.do")
				.param("seq", boards.get(0).getSeq())
				.param("div", boards.get(0).getDiv())
				.param("title", boards.get(0).getTitle()+"_U")
				.param("contents", boards.get(0).getContents()+"_U")
				.param("readCnt", boards.get(0).getReadCnt()+"")
				.param("regId", boards.get(0).getRegId())
				.param("modId", boards.get(0).getModId());		
		ResultActions  resultActions  = 
				mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = 
				resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("┌=============================┐");	
		LOG.debug("|result="+result);		
		LOG.debug("└=============================┘");	
		
		MessageVO messageVO =new Gson().fromJson(result, MessageVO.class);
		assertEquals("1", messageVO.getMsgId());		
	}
	
	@Test
	@Ignore
	public void doSave()throws Exception{
		//url, param, 호출방식
		MockHttpServletRequestBuilder requestBuilder 
			= MockMvcRequestBuilders.post("/board/doSave.do")
				.param("seq", boards.get(0).getSeq())
				.param("div", boards.get(0).getDiv())
				//.param("title", boards.get(0).getTitle())
				.param("contents", boards.get(0).getContents())
				.param("readCnt", boards.get(0).getReadCnt()+"")
				.param("regId", boards.get(0).getRegId())
				.param("modId", boards.get(0).getModId());
		
		ResultActions  resultActions  = 
				mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		String result = 
				resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("┌=============================┐");	
		LOG.debug("|result="+result);		
		LOG.debug("└=============================┘");		
		
		MessageVO messageVO =new Gson().fromJson(result, MessageVO.class);
		assertEquals("1", messageVO.getMsgId());
	}
	
	
	@Test
	public void bean() {
		LOG.debug("┌=============================┐");	
		LOG.debug("|webApplicationContext="+webApplicationContext);	
		LOG.debug("|dao="+dao);	
		LOG.debug("|mockMvc="+mockMvc);	
		LOG.debug("└=============================┘");
		
		assertNotNull(webApplicationContext);
		assertNotNull(dao);
		assertNotNull(mockMvc);
		
	}

}
