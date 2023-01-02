package com.pcwk.ehr.user.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	public UserServiceImpl() {}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//1. 업그레이드 대상 확인
	public boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();
		
		switch (currentLevel) {
		//레베렬로 구분해서 등업 조건을 판별한다.
		case BASIC: return(user.getLogin() >= MIN_LOGIN_COUNT_FOR_SILVER);
		case SILVER: return(user.getRecommend() >= MIN_RECOMMEND_COUNT_FOR_GOLD);
		case GOLD: return false;
		default: throw new IllegalArgumentException("Unknown Level: "+currentLevel);
		}
	}
	
	//업그레이드
	private void upgradeLevel(UserVO user) throws SQLException {
		user.upgradeLevel();
		
		userDao.doUpdate(user);
	}
	
	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
		//등업
		//-BASIC사용자 그리고 로그인이 50회 이상 -> SILVER
		//-SILVER 그리고 추천 30회 이상 -> GOLD
		//-GOLD 대상이 아님
		/*
		 * - 코드에 중복된 부분은 없는가?
		 * - 코드가 무엇을 하는지 이해하기 불편하지 않는가?
		 * - 코드가 자신이 있어야할 자리에 있는가?
		 * - 앞으로 변경이 일어난다면 어떤 것이 있을 수 있고, 그 변화에 쉽게 대응할 수 있게 작성 되어있는가? 
		 */
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
	}

	@Override
	public void add(UserVO inVO) throws SQLException {
		if(null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}
		
		userDao.add(inVO);
	}

}
