package com.pcwk.ehr;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
	
	final static Logger LOG = LogManager.getLogger(UserDaoTest.class); 
	UserDao dao;
	UserVO userVO;
	ConnectionMaker connectionMaker = new NConnectionMaker();
	ApplicationContext context;
	public UserDaoTest() {
		//dao = new DaoFactory().userDao();
		
		context = new AnnotationConfigApplicationContext(DaoFactory.class);
		dao = context.getBean("userDao", UserDao.class);
		
		LOG.debug("====================");
		LOG.debug("=context="+context);
		LOG.debug("=dao="+dao);
		LOG.debug("====================");
		
		userVO = new UserVO("p11", "이상무11", "4321");
	}
	
	public void add() {
		try {
			int flag = dao.add(userVO);
			if(1 == flag) {
				LOG.debug("등록 성공");
			} else {
				LOG.debug("등록 실패");
			}
			LOG.debug("=============================================");
			
			UserVO outVO = dao.get(userVO.getuId());
			if(null != outVO) {
				LOG.debug("조회 성공");
			} else {
				LOG.debug("조회 실패");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void get() {
		UserVO outVO;
		try {
			outVO = dao.get(userVO.getuId());
			if(null != outVO) {
				LOG.debug("조회 성공");
			} else {
				LOG.debug("조회 실패");
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	
		UserDaoTest main = new UserDaoTest();
		main.add();
		//main.get();
		
	}

}
