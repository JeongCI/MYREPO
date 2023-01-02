package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

//ApplicationContext context
//1회만 읽도록 수정
//스프링테스트 컨텍스트 프레임워크의 JUnit의 확장기능 지원
@RunWith(SpringJUnit4ClassRunner.class) //spring-test lib에 있음
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
								  ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//테스트 컨텍스트가 자동으로 만들어줄 애플리케이션 컨텍스트의 위치 지정
public class JUserDao {
	
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값이 주입된다.
	ApplicationContext context;
	//context : org.springframework.context.support.GenericApplicationContext@37883b97, started on Thu Nov 10 15:18:46 KST 2022
	//context : org.springframework.context.support.GenericApplicationContext@37883b97, started on Thu Nov 10 15:18:46 KST 2022
	UserDao dao;
	UserVO userVO01;
	UserVO userVO02;
	UserVO userVO03;
	UserVO userVO04;
	UserVO userVO05;
	UserVO search;

	@org.junit.Before
	public void setUp() throws Exception {
		
		dao = (UserDao) context.getBean("userDao");
		LOG.debug("=setUp()======================");
		LOG.debug("context : "+context);
		LOG.debug("dao : "+dao);
		LOG.debug("==============================");
		
		//null이 아니면 성공
		//assertNull(context); null 이면 true
		assertNotNull(context);
		assertNotNull(dao);
		
		userVO01 = new UserVO("p11_01", "이상무11_01", "4321",Level.BASIC,1,0,"jci1203@naver.com","날짜_사용하지 않음");
		userVO02 = new UserVO("p11_02", "이상무11_02", "4321",Level.SILVER,50,2,"ckdddls13@gmail.com","날짜_사용하지 않음");
		userVO03 = new UserVO("p11_03", "이상무11_03", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO04 = new UserVO("p11_04", "이상무11_04", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO05 = new UserVO("p11_05", "이상무11_05", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		
		search = new UserVO("p11", "이상무_search", "4321",Level.BASIC,1,0,"jci1203@naver.com","날짜_사용하지 않음");
	}
	
	@Test
	public void perform() throws SQLException {
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		dao.doDelete(userVO04);
		dao.doDelete(userVO05);
		dao.doSave(userVO01);
		assertEquals(dao.getCount(search), 1);
	}
	
	@Test
	public void doUpdate() throws SQLException {
		//1. 데이터 삭제
		//2. 신규 등록
		//3. 등록 데이터 조회
		//4. 수정
		//4.1. 한 건 조회
		//5. 수정 데이터 비교
		LOG.debug("=================================");
		LOG.debug("=doUpdate()======================");
		LOG.debug("=================================");
		
		//1. 데이터  삭제
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		dao.doDelete(userVO04);
		dao.doDelete(userVO05);
		
		//2.
		dao.doSave(userVO01);
		assertEquals(dao.getCount(search), 1);

		//3.
		UserVO getVO = dao.doSelectOne(userVO01);
		isSameUser(getVO, userVO01);
		
		//4.
		String upString = "_U";
		int upInt = 10;
		
		getVO.setName(getVO.getName()+upString);
		getVO.setPasswd(getVO.getPasswd()+upString);
		getVO.setEmail(getVO.getEmail()+upString);
		
		getVO.setLogin(getVO.getLogin()+upInt);
		getVO.setRecommend(getVO.getRecommend()+upInt);
		getVO.setLevel(Level.SILVER);
		
		//update
		dao.doUpdate(getVO);
		
		//5.
		UserVO vsVO = dao.doSelectOne(getVO);
		isSameUser(vsVO, getVO);
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
	public void getAll() {
		//1. 데이터 삭제
		//2. 데이터 1건 입력
		//3. 데이터 1건 확인
		
		//2. 데이터 1건 입력
		//3. 데이터 1건 확인
		
		//2. 데이터 1건 입력
		//3. 데이터 1건 확인
		
		//1.
		//삭제
		try {
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		dao.doDelete(userVO04);
		dao.doDelete(userVO05);
		
		//2.
		dao.doSave(userVO01);
		List<UserVO> list01 = dao.getAll(search);
		assertEquals(list01.size(), 1);
		this.isSameUser(list01.get(0), userVO01);
		
		dao.doSave(userVO02);
		List<UserVO> list02 = dao.getAll(search);
		assertEquals(list02.size(), 2);
		this.isSameUser(list02.get(1), userVO02);
		
		dao.doSave(userVO03);
		List<UserVO> list03 = dao.getAll(search);
		assertEquals(list03.size(), 3);
		this.isSameUser(list03.get(2), userVO03);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//NullPointerException.class가 발생하면 성공
	@Test(expected = NullPointerException.class)
	@Ignore
	public void getFailure() throws SQLException {
		LOG.debug("=================================");
		LOG.debug("=getFailure()=====================");
		LOG.debug("=================================");		
		dao.doDelete(userVO01);
		dao.doDelete(userVO02);
		dao.doDelete(userVO03);
		
		dao.doSelectOne(userVO01);
	}
	
	@SuppressWarnings("deprecation")
	@Test(timeout = 5000) //long 시간내에 수행이 되면 성공 / 그렇지않으면 실패
	public void addAndGet() {
		LOG.debug("=================================");
		LOG.debug("=addAndGet()=====================");
		LOG.debug("=================================");
		
		try {
			//삭제
			dao.doDelete(userVO01);
			dao.doDelete(userVO02);
			dao.doDelete(userVO03);
			dao.doDelete(userVO04);
			dao.doDelete(userVO05);
			
			
			//1건 추가
			int flag = dao.doSave(userVO01);
			assertEquals(flag, 1);
			assertEquals(dao.getCount(search), 1);
			
			//1건 추가
			flag = dao.doSave(userVO02);
			assertEquals(flag, 1);
			assertEquals(dao.getCount(search), 2);
			
			//1건 추가
			flag = dao.doSave(userVO03);
			assertEquals(flag, 1);
			assertEquals(dao.getCount(search), 3);
			
			//단건 조회
			UserVO vsVO01 = dao.doSelectOne(userVO01);
			UserVO vsVO02 = dao.doSelectOne(userVO02);
			UserVO vsVO03 = dao.doSelectOne(userVO03);
			
			//데이터 비교
			isSameUser(vsVO01,userVO01);
			isSameUser(vsVO02,userVO02);
			isSameUser(vsVO03,userVO03);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@org.junit.After
	public void tearDown() throws Exception {
		LOG.debug("=tearDown()======================");
		LOG.debug("=================================");
	}

	@Test
	@Ignore
	public void test() {
		LOG.debug("=test()======================");
	}

}
