package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.sql.SQLException;

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
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=================================");
		LOG.debug("=context= : "+context);
		LOG.debug("=userDao= : "+dao);
		LOG.debug("=================================");	
		
		userVO01 = new UserVO("p11_01", "유상무11_01", "4321",Level.BASIC,1,0,"jci1203@naver.com","날짜_사용하지 않음");
		userVO02 = new UserVO("p11_02", "인생무11_02", "4321",Level.SILVER,50,2,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO03 = new UserVO("p11_03", "견생무11_03", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO04 = new UserVO("p11_04", "이상무11_04", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		userVO05 = new UserVO("p11_05", "마마무11_05", "4321",Level.GOLD,100,31,"ckddls13@gmail.com","날짜_사용하지 않음");
		
		search = new UserVO("p11", "이상무_search", "4321",Level.BASIC,1,0,"jci1203@naver.com","날짜_사용하지 않음");		
	}
	
	@Test
	public void addAndGet() throws SQLException {
		LOG.debug("=================================");
		LOG.debug("=addAndGet()=====================");
		LOG.debug("=================================");
		
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
	}
	
	@Test
	@Ignore
	public void beans() {
		assertNotNull(context);
		assertNotNull(dao);
	}

}
