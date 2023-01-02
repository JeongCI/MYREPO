package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class) //spring-test lib에 있음
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
								  ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class JWebUserDao {
	
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값이 주입된다.
	ApplicationContext context;
	
	@Autowired
	UserDao dao;
	
	//테스트 데이터
	UserVO userVO01;
	UserVO userVO02;
	UserVO userVO03;
	UserVO userVO04;
	UserVO userVO05;
	UserVO search;
	SearchVO searchVO;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=================================");
		LOG.debug("=context= : "+context);
		LOG.debug("=userDao= : "+dao);
		LOG.debug("=================================");	
		
		userVO01 = new UserVO("p11_01", "마마무11_01", "4321",Level.BASIC,1,0,"jci1203@naver.com","날짜_사용하지 않음");
		userVO02 = new UserVO("p11_02", "마마무11_02", "4321",Level.SILVER,50,2,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO03 = new UserVO("p11_03", "마마무11_03", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO04 = new UserVO("p11_04", "마마무11_04", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO05 = new UserVO("p11_05", "마마무11_05", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		//데이터 검색용
		search = new UserVO("p11", "마마무_search", "4321",Level.BASIC,1,0,"jci1203@naver.com","날짜_사용하지 않음");
		//페이지  + 검색
		searchVO = new SearchVO(10,1,"10","p11");
	}
	
	public void isSameUser(UserVO actUser, UserVO addUser) {
		//데이터 비교
		assertEquals(actUser.getuId(), addUser.getuId());
		assertEquals(actUser.getName(), addUser.getName());
		assertEquals(actUser.getPasswd(), addUser.getPasswd());
		//level
		//login
		//recommend
		//email
		assertEquals(actUser.getLevel(), addUser.getLevel());
		assertEquals(actUser.getLogin(), addUser.getLogin());
		assertEquals(actUser.getRecommend(), addUser.getRecommend());
		assertEquals(actUser.getEmail(), addUser.getEmail());
	}
	
	@Test
	public void doRetrieve() throws SQLException {
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		dao.doDelete(userVO04);
		dao.doDelete(userVO05);
		
		dao.doSave(userVO01);
		dao.doSave(userVO02);
		dao.doSave(userVO03);
		dao.doSave(userVO04);
		dao.doSave(userVO05);
		
		List<UserVO> list = dao.doRetrieve(searchVO);
		
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
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		dao.doDelete(userVO04);
		dao.doDelete(userVO05);
		
		//2.
		dao.doSave(userVO01);
		assertEquals(1, dao.getCount(search));
		
		//3. 
		UserVO voVO01 = dao.doSelectOne(userVO01);
		isSameUser(voVO01, userVO01);
		
		//4.
		String upStr = "_U";
		int upInt = 100;
		voVO01.setName(voVO01.getName()+upStr);
		voVO01.setPasswd(voVO01.getPasswd()+upStr);
		voVO01.setLevel(Level.SILVER);
		voVO01.setLogin(voVO01.getLogin()+upInt);
		voVO01.setRecommend(voVO01.getRecommend()+upInt);
		voVO01.setEmail(voVO01.getEmail()+upStr);
		
		//5.
		assertEquals(1, dao.doUpdate(voVO01));
		
		//6.
		UserVO vsVOResult = dao.doSelectOne(voVO01);
		
		isSameUser(vsVOResult, voVO01);
	}
	
	@Test
	@Ignore
	public void addAndGet() throws SQLException {
		LOG.debug("=================================");
		LOG.debug("=addAndGet()=====================");
		LOG.debug("=================================");
		
		//삭제
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		dao.doDelete(userVO04);
		dao.doDelete(userVO05);
		
		//등록
		//1. 한 건 등록
		dao.doSave(userVO01);
		List<UserVO> list = dao.getAll(search);
		assertEquals(1, dao.getCount(search));
		isSameUser(userVO01, list.get(0));
		isSameUser(userVO01, dao.doSelectOne(userVO01));
		
		//2. 한 건 등록
		dao.doSave(userVO02);
		list = dao.getAll(search);
		assertEquals(2, dao.getCount(search));
		isSameUser(userVO02, list.get(1));
		isSameUser(userVO02, dao.doSelectOne(userVO02));

		//3. 한 건 등록
		dao.doSave(userVO03);
		list = dao.getAll(search);
		assertEquals(3, dao.getCount(search));
		isSameUser(userVO03, list.get(2));
		isSameUser(userVO03, dao.doSelectOne(userVO03));
	}
	
	@Test
	@Ignore
	public void beans() {
		assertNotNull(context);
		assertNotNull(dao);
	}

}
