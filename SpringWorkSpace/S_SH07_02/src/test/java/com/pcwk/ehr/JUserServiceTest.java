package com.pcwk.ehr;

import static org.junit.Assert.*;

//최소 로그인 수 실버로 등업
import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_LOGIN_COUNT_FOR_SILVER;
//최소 추천 수 골드로 등업
import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_RECOMMEND_COUNT_FOR_GOLD;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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

import com.pcwk.ehr.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUserServiceTest {
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDao dao;
	
	@Autowired
	UserService userService;
	
	//테스트 픽스처
	List<UserVO> users;
	
	//검색에 사용
	UserVO search;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                  setUp                    │");
		LOG.debug("└───────────────────────────────────────────┘");
		
		//BASIC
		//BASIC -> SILVER(O)
		//SILVER -> SILVER
		//SILVER -> GOLD(O)
		//GOLD
		
		users = Arrays.asList(
					 new UserVO("p11_01", "이상무11_01", "4321",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER-1,0,"jci1203@naver.com","날짜_사용하지 않음")
					,new UserVO("p11_02", "이상무11_02", "4322",Level.BASIC,MIN_LOGIN_COUNT_FOR_SILVER,0,"jci1203@naver.com","날짜_사용하지 않음")
					,new UserVO("p11_03", "이상무11_03", "4323",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+1,MIN_RECOMMEND_COUNT_FOR_GOLD-1,"jci1203@naver.com","날짜_사용하지 않음")
					,new UserVO("p11_04", "이상무11_04", "4324",Level.SILVER,MIN_LOGIN_COUNT_FOR_SILVER+2,MIN_RECOMMEND_COUNT_FOR_GOLD,"jci1203@naver.com","날짜_사용하지 않음")
					,new UserVO("p11_05", "이상무11_05", "4325",Level.GOLD,MIN_LOGIN_COUNT_FOR_SILVER+3,35,"jci1203@naver.com","날짜_사용하지 않음")
				);
		search = new UserVO("p11", "이상무11", "4321",Level.BASIC,49,0,"jci1203@naver.com","날짜_사용하지 않음");
	}
	
	//최초 가입자는 BASIC 등급 부여
	@Test
	public void add() throws SQLException {
		//1. users 데이터 삭제
		//2. Level이 있는 경우, Level이 null인 경우
		//3. 각각 추가
		//4. 각각 데이터 조회
		//5. 비교
		
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                    add                    │");
		
		//1.
		for(UserVO vo : users) {
			dao.deleteOne(vo);
		}
		
		//2.
		UserVO userWithOutLevel = users.get(0);
		userWithOutLevel.setLevel(null); // BASIC -> NULL
		
		//Level이 null이 아닌 경우
		UserVO userWithLevel = users.get(4);
		
		//3.
		userService.add(userWithOutLevel);
		userService.add(userWithLevel);
		
		//4. Level null -> BASIC
		UserVO userWithOutLevelGet =  dao.get(userWithOutLevel.getuId());
		assertEquals(userWithOutLevelGet.getLevel(), Level.BASIC);
		//Level GOLD -> GOLD
		UserVO userWithLevelGet =  dao.get(userWithLevel.getuId());
		assertEquals(userWithLevelGet.getLevel(), userWithLevel.getLevel());
		
		LOG.debug("│                    add                    │");
		LOG.debug("└───────────────────────────────────────────┘");
		
	}
	
	@Test
	public void upgradeLevels() throws Exception {
		//1. users 데이터 삭제
		//2. 데이터 입력
		//3. 등업
		//4. 등업한 데이터 비교
		
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│               upgradeLevels               │");
		//1.
		for(UserVO vo : users) {
			this.dao.deleteOne(vo);
		}
		
		//2.
		for(UserVO vo : users) {
			dao.add(vo);
		}
		assertEquals(5, dao.getCount(search));
		
		//3.
		this.userService.upgradeLevels(search);
		
		//4.
		checkLevel(users.get(0), false);
		checkLevel(users.get(1), true); // 등업 대상
		checkLevel(users.get(2), false);
		checkLevel(users.get(3), true); // 등업 대상
		checkLevel(users.get(4), false);
		
		LOG.debug("│               upgradeLevels               │");
		LOG.debug("└───────────────────────────────────────────┘");
	}
	
	/**
	 * upgraded가 true이면 다음 레벨로 등업
	 * @param user
	 * @param upgraded
	 * @throws SQLException
	 */
	private void checkLevel(UserVO user, boolean upgraded) throws SQLException {
		UserVO userUpLevel = dao.get(user.getuId());
		
		if(upgraded == true) {
			LOG.debug(userUpLevel.getLevel()+"=="+user.getLevel().nextLevel());
			assertEquals(userUpLevel.getLevel(), user.getLevel().nextLevel());
		//등업 대상이 아님
		} else {
			assertEquals(userUpLevel.getLevel(), user.getLevel());
		}
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                 tearDown                  │");
		LOG.debug("└───────────────────────────────────────────┘");
	}

	@Test
	public void beans() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│context : " + context);
		LOG.debug("│dao : " + dao);
		LOG.debug("│userService : " + userService);
		LOG.debug("└───────────────────────────────────────────┘");
		assertNotNull(context);
		assertNotNull(dao);
		assertNotNull(userService);
	}

}
