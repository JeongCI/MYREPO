package com.pcwk.ehr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//ApplicationContext context
//1회만 읽도록 수정
//스프링테스트 컨텍스트 프레임워크의 JUnit의 확장기능 지원
@RunWith(SpringJUnit4ClassRunner.class) //spring-test lib에 있음
@ContextConfiguration(locations = "/applicationContext.xml")
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
	UserVO search;

	@Before
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
		
		userVO01 = new UserVO("p11_01", "이상무11_01", "4321");
		userVO02 = new UserVO("p11_02", "이상무11_02", "4321");
		userVO03 = new UserVO("p11_03", "이상무11_03", "4321");
		
		search = new UserVO("p11", "이상무_search", "4321");
	}
	
	public void isSameUser(UserVO actUser, UserVO addUser) {
		//데이터 비교
		assertThat(actUser.getuId(), is(addUser.getuId()));
		assertThat(actUser.getName(), is(addUser.getName()));
		assertThat(actUser.getPassWd(), is(addUser.getPassWd()));
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
		dao.deleteOne(userVO01);
		dao.deleteOne(userVO02);
		dao.deleteOne(userVO03);
		
		//2.
		dao.add(userVO01);
		List<UserVO> list01 = dao.getAll(search);
		assertEquals(list01.size(), 1);
		this.isSameUser(list01.get(0), userVO01);
		
		dao.add(userVO02);
		List<UserVO> list02 = dao.getAll(search);
		assertEquals(list02.size(), 2);
		this.isSameUser(list02.get(1), userVO02);
		
		dao.add(userVO03);
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
		dao.deleteOne(userVO01);
		dao.deleteOne(userVO02);
		dao.deleteOne(userVO03);
		
		dao.get(userVO01.getuId());
	}
	
	@SuppressWarnings("deprecation")
	@Test(timeout = 5000) //long 시간내에 수행이 되면 성공 / 그렇지않으면 실패
	@Ignore
	public void addAndGet() {
		LOG.debug("=================================");
		LOG.debug("=addAndGet()=====================");
		LOG.debug("=================================");
		
		try {
			//삭제
			dao.deleteOne(userVO01);
			dao.deleteOne(userVO02);
			dao.deleteOne(userVO03);
			
			
			//1건 추가
			int flag = dao.add(userVO01);
			assertThat(flag, is(1));
			assertThat(dao.getCount(search), is(1));
			
			//1건 추가
			flag = dao.add(userVO02);
			assertThat(flag, is(1));
			assertThat(dao.getCount(search), is(2));
			
			//1건 추가
			flag = dao.add(userVO03);
			assertThat(flag, is(1));
			assertThat(dao.getCount(search), is(3));
			
			//단건 조회
			UserVO vsVO01 = dao.get(userVO01.getuId());
			UserVO vsVO02 = dao.get(userVO02.getuId());
			UserVO vsVO03 = dao.get(userVO03.getuId());
			
			//데이터 비교
			isSameUser(vsVO01,userVO01);
			isSameUser(vsVO02,userVO02);
			isSameUser(vsVO03,userVO03);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@After
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
