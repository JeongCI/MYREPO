package com.pcwk.ehr.user.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pcwk.ehr.UserVO;

public class TestUserService extends UserServiceImpl {

	final Logger LOG = LogManager.getLogger(getClass());

	// 4번째 사용자가 들어 오면 예외 발생
	private String uId;

	public TestUserService() {
	}

	public TestUserService(String uId) {
		super();
		this.uId = uId;
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│uId: "+uId);
		LOG.debug("└───────────────────────────────────────────┘");
	}

	@Override
	public void upgradeLevel(UserVO user) throws SQLException, TestUserServiceException{
		if(uId.equals(user.getuId())) {
			throw new TestUserServiceException("TestUserServiceException"+uId);
		}
		super.upgradeLevel(user);
	}
}
