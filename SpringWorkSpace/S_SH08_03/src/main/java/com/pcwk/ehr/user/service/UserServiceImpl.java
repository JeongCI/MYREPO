package com.pcwk.ehr.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.Level;
import com.pcwk.ehr.UserDao;
import com.pcwk.ehr.UserVO;

public class UserServiceImpl implements UserService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	//50,30 대한 상수 도입
	//최소 로그인 수 실버로 등업 : 50
	public final static int MIN_LOGIN_COUNT_FOR_SILVER = 50;
	//최소 추천 수 골드로 등업 : 30
	public final static int MIN_RECOMMEND_COUNT_FOR_GOLD = 30;
	
	
	//dao
	private UserDao userDao;
	
	private DataSource dataSource;
	
	private PlatformTransactionManager transactionManager;
	
	public UserServiceImpl() {}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	//1. 업그레이드 대상 확인
	public boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();
		
		switch (currentLevel) {
		//레벨별로 구분해서 등업 조건을 판별한다.
		case BASIC: return(user.getLogin() >= MIN_LOGIN_COUNT_FOR_SILVER);
		case SILVER: return(user.getRecommend() >= MIN_RECOMMEND_COUNT_FOR_GOLD);
		case GOLD: return false;
		default: throw new IllegalArgumentException("Unknown Level: "+currentLevel);
		}
	}
	
	//업그레이드
	public void upgradeLevel(UserVO user) throws SQLException {
		user.upgradeLevel();
		
		userDao.doUpdate(user);
	}
	
	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
		//Spring 트랜잭션 처리
		//PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource); //JDBC트랜잭션 추상 Object
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			//1. 대상 사용자 조회
			List<UserVO> allUser = userDao.getAll(inVO);
			//2.
			for(UserVO vo : allUser) {
				//2.1. 등업 대상자 추출
				if(canUpgradeLevel(vo) == true) {
					//등업
					upgradeLevel(vo);
				}
			}
			
			transactionManager.commit(status);
		} catch (Exception e) {
			LOG.debug("┌───────────────────────────────────────────┐");
			LOG.debug("│rollback: "+e.getMessage());
			LOG.debug("└───────────────────────────────────────────┘");
			transactionManager.rollback(status);
			throw e;
		} finally {
			//DB커넥션 자원 반납
		}

	}

	@Override
	public void add(UserVO inVO) throws SQLException {
		if(null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}
		
		userDao.add(inVO);
	}

}
