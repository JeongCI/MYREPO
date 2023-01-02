package com.pcwk.ehr.user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Controller("userController")
public class UserController {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	
	@Autowired
	UserService userService;
	
	//화면 파일
	final String VIEW_NAME = "user/user_mng";
	
	public UserController() {}
	
	//화면
	@RequestMapping(value = "user/view.do")
	public String view() {
		LOG.debug("┌──────────────────────────────────┐");
		LOG.debug("│=view=");
		LOG.debug("└──────────────────────────────────┘");
		/*
		 * prefix = /WEB-INF/views/
		 * 		user/user_mng => /WEB-INF/views/user/user_mng.jsp
		 * suffix = .jsp
		 */
		return VIEW_NAME;
	}
	
	@RequestMapping(value = "user/doDelete.do", method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doDelete(HttpServletRequest req,UserVO inVO) throws SQLException{
		String jsonString = "999999";
		
		LOG.debug("┌──────────────────────────────────┐");
		String uId = req.getParameter("uId");
		LOG.debug("│=uId= : " + uId);
		
		UserVO inpuVO = new UserVO();
		inpuVO.setuId(uId);
		
		LOG.debug("│=inpuVO= : " + inpuVO);
		int flag = userService.doDelete(inpuVO);
		
		LOG.debug("│=flag= : " + flag);
		LOG.debug("└──────────────────────────────────┘");
		
		return jsonString;
	}
	
}
