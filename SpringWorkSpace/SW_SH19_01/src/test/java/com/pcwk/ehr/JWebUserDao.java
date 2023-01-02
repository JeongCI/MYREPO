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

@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class JWebUserDao {
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값으 주입된다.
	ApplicationContext context;
	
	@Autowired 
	UserDao dao;
	
	//테스트 데이터 
	UserVO   userVO1;
	UserVO   userVO2;
	UserVO   userVO3;
	UserVO   userVO4;
	UserVO   userVO5;
	
	SearchVO   searchVO;	
	UserVO   search;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("==============================");
		LOG.debug("context:"+context);	
		LOG.debug("userDao:"+dao);
		LOG.debug("==============================");
		userVO1 = new UserVO("p99_01", "이상무99_01", "4321",Level.BASIC,1,0,"jamesol@paran.com","날짜_사용하지 않음");
		userVO2 = new UserVO("p99_02", "이상무99_02", "4321",Level.SILVER,50,2,"jamesol@paran.com","날짜_사용하지 않음");
		userVO3 = new UserVO("p99_03", "이상무99_03", "4321",Level.GOLD,100,31,"jamesol@paran.com","날짜_사용하지 않음");
		userVO4 = new UserVO("p99_04", "이상무99_04", "4321",Level.SILVER,50,2,"jamesol@paran.com","날짜_사용하지 않음");
		userVO5 = new UserVO("p99_05", "이상무99_05", "4321",Level.GOLD,100,31,"jamesol@paran.com","날짜_사용하지 않음");
        //데이터 검색용
		search  = new UserVO("p99", "이상무99_05", "4321",Level.GOLD,100,31,"jamesol@paran.com","날짜_사용하지 않음");
		//페이지+검색
		searchVO  = new SearchVO(10,1,"10","p99","");
	}
	
	@Test
	public void idCheck() throws SQLException{
		//1.전부삭제
		//2.한건등록
		//3.idCheck호출 ==1
		
		//.1
		dao.doDelete(userVO1);		
		dao.doDelete(userVO2);
		dao.doDelete(userVO3);
		dao.doDelete(userVO4);
		dao.doDelete(userVO5);  
		
		//2.
		dao.doSave(userVO1);
		assertEquals(1, dao.getCount(search));
		
		userVO1.setuId("u99");
		//3.
		assertEquals(0, dao.idCheck(userVO1)); 
		
	}
	
	@Test
	@Ignore
	public void doRetrieve() throws SQLException{
		//1.
		dao.doDelete(userVO1);		
		dao.doDelete(userVO2);
		dao.doDelete(userVO3);
		dao.doDelete(userVO4);
		dao.doDelete(userVO5);
		
		dao.doSave(userVO1);
		dao.doSave(userVO2);
		dao.doSave(userVO3);
		dao.doSave(userVO4);
		dao.doSave(userVO5);
		
		List<UserVO> list = dao.doRetrive(searchVO);
		//assert
		
		
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
	@Ignore
	public void doUpdate() throws SQLException{
		//1. 삭제
		//2. 등록
		//3. 한건조회
		//4. 한건조회 데이터 수정
		//5. 수정
		//6. 한건조회
		//7. 비교
		
		//1.
		dao.doDelete(userVO1);		
		dao.doDelete(userVO2);
		dao.doDelete(userVO3);
		dao.doDelete(userVO4);
		dao.doDelete(userVO5);
		
		//2.
		dao.doSave(userVO1);
		assertEquals(1, dao.getCount(search));
		
		//3.
		UserVO voVO01 = dao.doSelectOne(userVO1);
		isSameUser(voVO01, userVO1);
		
		String upStr = "_U";
		int upInt    = 100;
		
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
		LOG.debug("==============================");
		LOG.debug("=addAndGet()=");
		LOG.debug("==============================");	
		//삭제
		dao.doDelete(userVO1);		
		dao.doDelete(userVO2);
		dao.doDelete(userVO3);
		dao.doDelete(userVO4);
		dao.doDelete(userVO5);
        
		//등록		
		//1 한건 등록
		dao.doSave(userVO1);
		List<UserVO> list= dao.getAll(search);
		assertEquals(1, dao.getCount(search));
		isSameUser(userVO1, list.get(0));
		isSameUser(userVO1, dao.doSelectOne(userVO1));

		//2 한건 등록
		dao.doSave(userVO2);
		list= dao.getAll(search);
		assertEquals(2, dao.getCount(search));
		isSameUser(userVO2, list.get(1));
		
		//3 한건 등록		
		dao.doSave(userVO3);
		list= dao.getAll(search);
		assertEquals(3, dao.getCount(search));
		isSameUser(userVO3, list.get(2));		
	
		

	}
	
    
	@Test
	@Ignore
	public void beans() {
		assertNotNull(context);
		assertNotNull(dao);
	}

}
