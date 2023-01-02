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
	
	//dao
	private UserDao userDao;
	
	public UserServiceImpl() {}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
		
		//1.대상 사용자 조회
		
		//등업
		//-BASIC사용자 그리고 로그인이 50회 이상 -> SILVER
		//-SILVER 그리고 추천 30회 이상 -> GOLD
		//-GOLD 대상이 아님
		
		//1.
		List<UserVO> allUser = userDao.getAll(inVO);
		
		//2.
		for(UserVO vo : allUser) {
			boolean changeLevel = false;
			//2.1. 등업 대상자 추출
			if(vo.getLevel() == Level.BASIC && vo.getLogin() >= 50) {
				changeLevel = true;
				vo.setLevel(Level.SILVER);
			} else if (vo.getLevel() == Level.SILVER && vo.getRecommend() >= 30) {
				changeLevel = true;
				vo.setLevel(Level.GOLD);
			} else if (vo.getLevel() == Level.GOLD) {
				changeLevel = false;
			} else {
				changeLevel = false;
			}
			
			//2.2. 등업
			if(true == changeLevel) {
				userDao.doUpdate(vo);
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
