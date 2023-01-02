package com.pcwk.ehr.exception;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ehr.user.domain.UserVO;

@Controller
@RequestMapping("except")
public class ExceptionController {
	
	final Logger LOG = LogManager.getFormatterLogger(getClass());	
	
	@RequestMapping( value = "/nullPointerException.do", method = RequestMethod.GET)
	public String nullPointerException(UserVO inVO) {
		if(null == inVO.getuId() || "".equals(inVO.getuId())) {
			LOG.debug("┌──────────────────────────────────┐");
			LOG.debug("│=nullPointerException= inVO.getuId() : "+inVO.getuId());
			LOG.debug("└──────────────────────────────────┘");	
			throw new NullPointerException("아이디를 입력 하세요.");
		}
		return "user/user_mng";
	}
}
