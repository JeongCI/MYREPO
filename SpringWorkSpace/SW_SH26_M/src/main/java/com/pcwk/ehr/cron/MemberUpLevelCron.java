package com.pcwk.ehr.cron;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Component
public class MemberUpLevelCron {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	//검색에 사용
	UserVO search = 
			new UserVO("p99", "이상무99_01", "4321",Level.BASIC,49,0,"jamesol@paran.com","날짜_사용하지 않음");
	public MemberUpLevelCron() {
		
	}
	
	public void upgradeLevels() {
		try {
			userService.upgradeLevels(search);
		} catch (SQLException e) {
			LOG.debug("=====================");
			LOG.debug("=SQLException=="+e.getMessage());
			LOG.debug("=====================");
			e.printStackTrace();
		}
	}
	
	
}
