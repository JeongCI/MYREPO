package com.pcwk.ehr;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pcwk.ehr.cmn.StringUtil;

public class Log4JTest {
	
    final static Logger LOG = LogManager.getLogger(Log4JTest.class);
    
	public static void main(String[] args) {
		LOG.debug("=========================");
		LOG.debug("==main====");
		LOG.debug("=========================");

		//UUID
		UUID  uuid=UUID.randomUUID();
		LOG.debug(uuid.toString());
		//32
		LOG.debug("b1d85530-f322-48d8-b91a-958ff1fa2912".replace("-", "") .length());
		//YYYYMMDD
		
		// 현재 날짜 객체를 생성
		//8
		LocalDate date = LocalDate.now();
		LOG.debug("dateString:"+date.toString());
		LOG.debug(StringUtil.getPK());
		LOG.debug(StringUtil.getPK().length());
		

	}

}
