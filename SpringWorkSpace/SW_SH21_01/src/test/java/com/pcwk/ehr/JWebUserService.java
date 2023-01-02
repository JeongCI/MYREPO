package com.pcwk.ehr;

import static org.junit.Assert.*;

//최소 로그인 수 실버로 등업
//최소 추천 수 골드로 등업
import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_LOGIN_COUNT_FOR_SILVER;
import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_RECOMMEND_COUNT_FOR_GOLD;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
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
import org.springframework.transaction.PlatformTransactionManager;

import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.TestUserService;
import com.pcwk.ehr.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebUserService {
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired
	ApplicationContext  context;
	
	@Autowired
	UserDao dao;
	
	@Autowired
	UserService  userService;
	
	@Autowired
	PlatformTransactionManager  transactionManager;
	
	//테스트 픽스처
	List<UserVO> users;
	
	//검색에 사용
	UserVO search;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|setUp:                                     |");
		LOG.debug("└-------------------------------------------┘");		
		
		//BASIC
		//BASIC->SILVER(O)
		//SILVER->SILVER
		//SILVER->GOLD(O)
		//GOLD
		//-BASIC사용자 그리고 로그인이 50회 이상 -> SILVER
		//-SILVER 그리고 추천 30회 이상 -> GOLD
		//-GOLD 대상이 아님
		users = Arrays.asList(
				 new UserVO("p99_01", "이상무99_01", "4321",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER-1,0,"jamesol@paran.com","날짜_사용하지 않음")
				,new UserVO("p99_02", "이상무99_02", "4322",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER,0,"jamesol@paran.com","날짜_사용하지 않음") 
				,new UserVO("p99_03", "이상무99_03", "4323",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+1,MIN_RECOMMEND_COUNT_FOR_GOLD-1,"jamesol@paran.com","날짜_사용하지 않음")
				,new UserVO("p99_04", "이상무99_04", "4324",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+2,MIN_RECOMMEND_COUNT_FOR_GOLD,"jamesol@paran.com","날짜_사용하지 않음")
				,new UserVO("p99_05", "이상무99_05", "4325",Level.GOLD,MIN_LOGIN_COUNT_FOR_SILVER+3,35,"jamesol@paran.com","날짜_사용하지 않음")
				);
		search = new UserVO("p99", "이상무99_01", "4321",Level.BASIC,49,0,"jamesol@paran.com","날짜_사용하지 않음");
	}

	
	@Test
	public void upDeleteAll()throws SQLException{
		//1.기존데이터 삭제
		//2.데이터 입력
		//3.전부삭제
		
		try {
			//1.
			for(UserVO vo  :users) {
				userService.doDelete(vo);
			}
			
			//2.
			for(UserVO vo  :users) {
			    userService.add(vo);
			}
			
			assertEquals(5, userService.getCount(search));
			
			//3.
			for(UserVO vo :users.subList(0, 2)) {
				LOG.debug("|vo()"+vo);
			}
			assertEquals(5,userService.upDeleteAll(users));
			
			assertEquals(0, userService.getCount(search));
			   
		}catch(Exception e) {
			LOG.debug("┌-upDeleteAll()------------------------------------------┐");
			LOG.debug("|upDeleteAll()"+e.getMessage());
			LOG.debug("└-upDeleteAll()------------------------------------------┘");			
		}
		
	}
	
	
	//최초 가입자는 등급을 BASIC
	@Test
	@Ignore
	public void add() throws SQLException {
		//1. users데이터 삭제
		//2. Level이 있는 경우, Level이 NULL인 경우
		//3. 각각 추가
		//4. 각각 데이터 조회
		//5. 비교
		
		LOG.debug("┌-add()------------------------------------------┐");
		
		//1.
		for(UserVO vo   :users) {
			userService.doDelete(vo);
		}
		
		//2.
		UserVO userWithOutLevel = users.get(0);
		userWithOutLevel.setLevel(null);//BASIC -> NULL
		
		//Level이 Null이 아닌 경우
		UserVO userWithLevel = users.get(4);
		
		//3.
		userService.add(userWithOutLevel);
		userService.add(userWithLevel);
		
		//4. Level null - > BASIC
		UserVO userWithOutLevelGet = userService.doSelectOne(userWithOutLevel);
		assertEquals(userWithOutLevelGet.getLevel(), Level.BASIC);
		
		//Level GOLD - > GOLD
		UserVO userWithLevelGet  = userService.doSelectOne(userWithLevel);
		assertEquals(userWithLevelGet.getLevel(), userWithLevel.getLevel());
		LOG.debug("└-add()------------------------------------------┘");	
	}
	
	@Test
	@Ignore
	public void allOrNothing()throws SQLException{
		/*
		 * 5명중 2명에 등업 대상자 있음
		 * 4번째에서 강제로 예외 발생
		 * 2번째 사용자가 rollback 되면 성공!(BASIC->SILVER) BASIC 으로 돌아 오면 됨.
		 */
		//p99_04
		TestUserService  testUserService=new TestUserService(users.get(3).getuId());
		//testUserService.setUserDao(dao);//dao 수동 주입
		//testUserService.setTransactionManager(transactionManager);
		//1. users데이터 삭제
		//2. 데이터 입력
		//3. 등업
		
		try {
			//1.
			for(UserVO vo :users) {
				dao.doDelete(vo);
			}
			
			//2.
			for(UserVO vo :users) {
				dao.doSave(vo);
			}
			assertEquals(5, dao.getCount(search));
			
			//3.
			testUserService.upgradeLevels(search);
			   

			
		}catch(Exception e) {
			LOG.debug("┌-upgradeLevels()------------------------------------------┐");
			LOG.debug("|allOrNothing()"+e.getMessage());
			LOG.debug("└-upgradeLevels()------------------------------------------┘");
		}
		
		checkLevel(users.get(1), false);//등업 대상: 등업이 되었고 rollback되지 않음
		
		
	}
	
	@Test
	@Ignore
	public void upgradeLevels() throws Exception {
		//1. users데이터 삭제
		//2. 데이터 입력
		//3. 등업
		//4. 등업 데이터 비교
		LOG.debug("┌-upgradeLevels()------------------------------------------┐");
		
		//1.
		for(UserVO vo :users) {
			userService.doDelete(vo);
		}
		
		//2.
		for(UserVO vo :users) {
			userService.add(vo);
		}
		assertEquals(5, userService.getCount(search));
		
		//3.
		try {
			this.userService.upgradeLevels(search);
		}catch (Exception e) {
			LOG.debug("┌-Exception()------------------------------------------┐");
			LOG.debug("| "+e.getMessage());
			LOG.debug("└-Exception()------------------------------------------┘");		
		}
		
		//4.
		checkLevel(users.get(0), false);
		checkLevel(users.get(1), true);//등업 대상->rollback
		checkLevel(users.get(2), false);
		checkLevel(users.get(3), true);//등업 대상->rollback
		checkLevel(users.get(4), false);
		
		
		LOG.debug("└-upgradeLevels()------------------------------------------┘");		
	}
    
	/**
	 * upgraded가 true이면 다음 레벨로 등업
	 * @param user
	 * @param upgraded : true/false
	 * @throws SQLException
	 */
	private void checkLevel(UserVO user, Boolean upgraded) throws SQLException {
		UserVO userUpLevel = dao.doSelectOne(user);
		
		//등업
		if(upgraded == true) {
			LOG.debug(userUpLevel.getLevel()+"=="+user.getLevel().nextLevel());
			assertEquals(userUpLevel.getLevel(), user.getLevel().nextLevel());
		//등업 대상이 아님	
		}else {
			assertEquals(userUpLevel.getLevel(), user.getLevel());
		}
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|tearDown:                                  |");
		LOG.debug("└-------------------------------------------┘");		
	}
	
	@Test
	@Ignore
	public void beans() {
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|context:"+context                        +"|");
		LOG.debug("|dao:"+dao                                +"|");
		LOG.debug("|userService:"+userService                +"|");
		LOG.debug("└-------------------------------------------┘");
		
		assertNotNull(transactionManager);
		assertNotNull(context);
		assertNotNull(dao);
		assertNotNull(userService);
	}

}
