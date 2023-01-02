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

@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-test-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebBoardDao {
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값으 주입된다.
	ApplicationContext context;
	
	@Autowired
	BoardDao  dao;
	
	BoardVO   board01;
	BoardVO   board02;
	BoardVO   board03;
	BoardVO   board04;
	BoardVO   board05;
	
	SearchVO  searchVO;
	BoardVO   search;
	
	@Before
	public void setUp() throws Exception {
		
		board01= new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-99_01", "10", "제목_01", "내용_01", 0, "", "admin", "", "admin");
		board02= new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-99_02", "20", "제목_02", "내용_02", 1, "", "admin", "", "admin");
		board03= new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-99_03", "10", "제목_03", "내용_03", 2, "", "admin", "", "admin");
		board04= new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-99_04", "10", "제목_04", "내용_04", 3, "", "admin", "", "admin");
		board05= new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af-99_05", "10", "제목_05", "내용_05", 4, "", "admin", "", "admin");
		
		search = new BoardVO("2022120118b290a3a4fa4fc99c9ebfc9af", "10", "제목_05", "내용_05", 4, "", "admin", "", "admin");
		searchVO  = new SearchVO(10,1,"","","");
	}
   
	@Test
	public void doRetrive()throws SQLException{
		//1.
		dao.doDelete(board01);
		dao.doDelete(board02);
		dao.doDelete(board03);
		dao.doDelete(board04);
		dao.doDelete(board05);
		
		
		//2.
		dao.doSave(board01);
		dao.doSave(board02);
		dao.doSave(board03);
		dao.doSave(board04);
		dao.doSave(board05);
		
		searchVO.setDiv("20");
		//searchVO.setSearchDiv("30");
		//searchVO.setSearchWord("JCI");
		List<BoardVO> list = dao.doRetrive(searchVO);
		
	}
	
	   
	@Test
	@Ignore
	public void updateReadCnt()throws SQLException{
		//1. 삭제
		//2. 등록
		//3. 한건조회
		//4. 조회count증가
		//5. 단건조회 : 
		//6. 조회count비교
		
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
		
		//4. 조회count증가
		int flag = dao.updateReadCnt(board01);
		LOG.debug("flag:"+flag);
		
		out01 = dao.doSelectOne(board01);
		
		//LOG.debug("out01.getReadCnt():"+out01.getReadCnt());
		//LOG.debug("board01.getReadCnt():"+board01.getReadCnt());
		
		//조회count증가
		assertEquals(out01.getReadCnt(), board01.getReadCnt()+1);
		
	}
	
	
	@Test
	@Ignore
	public void doUpdate()throws SQLException{
		//1. 삭제
		//2. 등록
		//3. 한건조회
		//4. 한건조회 데이터 수정
		//5. 수정
		//6. 한건조회
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
		int upInt    = 10;
		
		out01.setDiv("20");
		out01.setTitle(out01.getTitle()+upStr);
		out01.setContents(out01.getContents()+upStr);
		out01.setReadCnt(out01.getReadCnt()+upInt);
		out01.setModId(out01.getModId()+upInt);
		
		//4.
		dao.doUpdate(out01);
		
		//5.
		BoardVO vsResult =  dao.doSelectOne(out01);
		
		isSameData(vsResult,out01);
		
	}
	
	@Test
	@Ignore
	public void addAndGet()throws SQLException{
		//1.삭제
		//2.추가
		//3.단건조회
		//4.비교
		
		//1.
		dao.doDelete(board01);
		dao.doDelete(board02);
		dao.doDelete(board03);
		dao.doDelete(board04);
		dao.doDelete(board05);
		
		
		//2.
		dao.doSave(board01);
		dao.doSave(board02);
		dao.doSave(board03);
		dao.doSave(board04);
		dao.doSave(board05);
		
		//3.
		BoardVO out01 = dao.doSelectOne(board01);
		BoardVO out02 = dao.doSelectOne(board02);
		BoardVO out03 = dao.doSelectOne(board03);
		LOG.debug("out01:"+out01);
		isSameData(out01, board01);
		isSameData(out02, board02);
		isSameData(out03, board03);
	}
	
	public void isSameData(BoardVO actual,BoardVO expected) {
		assertEquals(actual.getSeq(), expected.getSeq());
		assertEquals(actual.getDiv(), expected.getDiv());
		
		assertEquals(actual.getTitle(), expected.getTitle());
		assertEquals(actual.getContents(), expected.getContents());
		assertEquals(actual.getReadCnt(), expected.getReadCnt());
		//assertEquals(actual.getRegId(), expected.getRegId());
		assertEquals(actual.getModId(), expected.getModId());
	}
	
	
	@Test
	@Ignore
	public void beans() {
		LOG.debug("==============================");
		LOG.debug("context:"+context);	
		LOG.debug("dao:"+dao);
		LOG.debug("uuid:"+StringUtil.getPK());
		LOG.debug("==============================");
		
		assertNotNull(context);
		assertNotNull(dao);
	}

}
