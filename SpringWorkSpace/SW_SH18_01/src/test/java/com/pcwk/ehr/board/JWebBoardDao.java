package com.pcwk.ehr.board;

import static org.junit.Assert.*;

import java.sql.SQLException;
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
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.board.dao.BoardDao;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class) //spring-test lib에 있음
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
								  ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebBoardDao {
	
	final Logger LOG = LogManager.getLogger(getClass());	
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값이 주입된다.
	ApplicationContext context;
	
	@Autowired
	BoardDao dao;
	
	BoardVO board01;
	BoardVO board02;
	BoardVO board03;
	BoardVO board04;
	BoardVO board05;
	
	SearchVO searchVO;
	BoardVO search;
	
	@Before
	public void setUp() throws Exception {
		//20221201e529415d6a07412d8872219ac2921838p11_01
		//20221201e529415d6a07412d8872219ac2921838p11_02
		//20221201e529415d6a07412d8872219ac2921838p11_03
		//20221201e529415d6a07412d8872219ac2921838p11_04
		//20221201e529415d6a07412d8872219ac2921838p11_05
		
		board01 = new BoardVO("20221201e529415d6a07412d8872219298p11_01", "10", "제목_01", "내용_01", 0, "", "JCI", "", "JCI");
		board02 = new BoardVO("20221201e529415d6a07412d8872219298p11_02", "10", "제목_02", "내용_02", 1, "", "JCI", "", "JCI");
		board03 = new BoardVO("20221201e529415d6a07412d8872219298p11_03", "10", "제목_03", "내용_03", 2, "", "JCI", "", "JCI");
		board04 = new BoardVO("20221201e529415d6a07412d8872219298p11_04", "10", "제목_04", "내용_04", 3, "", "JCI", "", "JCI");
		board05 = new BoardVO("20221201e529415d6a07412d8872219298p11_05", "10", "제목_05", "내용_05", 4, "", "JCI", "", "JCI");
		
		search = new BoardVO("20221201e529415d6a07412d8872219298", "10", "제목_05", "내용_05", 4, "", "JCI", "", "JCI");
		searchVO = new SearchVO(10, 1, "", "","");
	}
	
	@Test
	public void doRetrieve() throws SQLException {
		//1. 삭제
		dao.doDelete(board01);
		dao.doDelete(board02);
		dao.doDelete(board03);
		dao.doDelete(board04);
		dao.doDelete(board05);
		
		//2. 등록
		dao.doSave(board01);
		dao.doSave(board02);
		dao.doSave(board03);
		dao.doSave(board04);
		dao.doSave(board05);
		
		//3. 조회
		//searchVO.setSearchDiv("30");
		//searchVO.setSearchWord("JCI");
		searchVO.setDiv("20");
		List<BoardVO> list = dao.doRetrieve(searchVO);
	}

	@Test
	@Ignore
	public void updateReadCnt() throws SQLException {
		//1. 삭제
		//2. 등록
		//3. 한건 조회
		//4. 조회수 증가
		//5. 단건 조회: 
		//6. 조회count 비교
		
		dao.doDelete(board01);
		dao.doDelete(board02);
		dao.doDelete(board03);
		dao.doDelete(board04);
		dao.doDelete(board05);
		
		//2.
		dao.doSave(board01);
		
		//3. 
		BoardVO out01 = dao.doSelectOne(board01);
		isSameData(out01, board01);
		
		//4.
		dao.updateReadCnt(board01);
		
		//5.
		out01 = dao.doSelectOne(board01);
		
		//6.
		assertEquals(out01.getReadCnt(), board01.getReadCnt()+1);
	}
		
	@Test
	@Ignore
	public void addAndGet() throws SQLException {
		//1. 삭제
		//2. 추가
		//3. 단건 조회
		//4. 비교
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│=addAndGet=");
		LOG.debug("└───────────────────────────────────────────┘");
		
		//1. 삭제
		dao.doDelete(board01);
		dao.doDelete(board02);
		dao.doDelete(board03);
		dao.doDelete(board04);
		dao.doDelete(board05);
		
		//2. 등록
		dao.doSave(board01);
		dao.doSave(board02);
		dao.doSave(board03);
		dao.doSave(board04);
		dao.doSave(board05);
		
		//3. 조회
		BoardVO out01 = dao.doSelectOne(board01);
		BoardVO out02 = dao.doSelectOne(board02);
		BoardVO out03 = dao.doSelectOne(board03);
		LOG.debug("│=out01= : " + out01);
		isSameData(out01, board01);
		isSameData(out02, board02);
		isSameData(out03, board03);
	}

	@Test
	@Ignore
	public void doUpdate() throws SQLException {
		//1. 삭제
		//2. 등록
		//3. 한건 조회
		//4. 한건 조회 데이터 수정
		//5. 수정
		//6. 한건 조회
		//7. 비교
		
		//1.
		dao.doDelete(board01);
		dao.doDelete(board02);
		dao.doDelete(board03);
		dao.doDelete(board04);
		dao.doDelete(board05);
		
		//2.
		dao.doSave(board01);
		//3. 
		BoardVO out01 = dao.doSelectOne(board01);
		isSameData(out01, board01);
		
		String upStr = "_U";
		int upInt = 10;
		out01.setDiv("20");
		out01.setTitle(out01.getTitle()+upStr);
		out01.setContents(out01.getContents()+upStr);
		out01.setReadCnt(out01.getReadCnt()+upInt);
		out01.setModId(out01.getModId()+upStr);
		
		//4.
		dao.doUpdate(out01);
		
		//5.
		BoardVO vsResult = dao.doSelectOne(out01);
		
		isSameData(vsResult, out01);
	}	
	
	public void isSameData(BoardVO acutual, BoardVO expected) {
		assertEquals(acutual.getSeq(), expected.getSeq());
		assertEquals(acutual.getDiv(), expected.getDiv());
		assertEquals(acutual.getTitle(), expected.getTitle());
		assertEquals(acutual.getContents(), expected.getContents());
		assertEquals(acutual.getReadCnt(), expected.getReadCnt());
		//assertEquals(acutual.getRegId(), expected.getRegId());
		assertEquals(acutual.getModId(), expected.getModId());
	}

	@Test
	@Ignore
	public void beans() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│=context= : " + context);
		LOG.debug("│=dao= : " + dao);
		LOG.debug("│=uuid= : " + StringUtil.getPK());
		LOG.debug("└───────────────────────────────────────────┘");
		
		
		assertNotNull(context);
		assertNotNull(dao);
	}
	
	
}
