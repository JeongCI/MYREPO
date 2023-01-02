package com.pcwk.ehr.user.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Controller("userController")
@RequestMapping("user")
public class UserController {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	
	@Autowired
	UserService userService;
	
	//화면 파일
	final String VIEW_NAME = "user/user_mng";
	
	public UserController() {}
	
	//화면
	@RequestMapping(value = "/view.do")
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
	
	@RequestMapping(value = "doRetrieve.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String doRetrieve(SearchVO inVO) throws SQLException {
		String jsonString = "";

		if(0 == inVO.getPageSize()) {
			inVO.setPageSize(10);
		}
		
		if(0 == inVO.getPageNo()) {
			inVO.setPageNo(1); 
		}
		
		if(null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}
		
		if(null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		}
		
		LOG.debug("┌──────────────────────────────────┐");
		LOG.debug("│=inVO= : " + inVO);
		
		List<UserVO> list = userService.doRetrieve(inVO);
		jsonString = new Gson().toJson(list);
		
		LOG.debug("│=jsonString= : " + jsonString);
		LOG.debug("└──────────────────────────────────┘");
		
		return jsonString;
	}
	
	@RequestMapping(value = "doUpdate.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String doUpdate(UserVO inVO) throws SQLException {
		String jsonString = "";
		LOG.debug("┌──────────────────────────────────┐");
		LOG.debug("│=inVO= : " + inVO);
		int flag = userService.doUpdate(inVO);
		
		String message = "";
		if(1 == flag) {
			message = inVO.getuId()+"수정 되었습니다.";
		} else {
			message = inVO.getuId()+"수정 실패";
		}
		
		MessageVO messageVO = new MessageVO(String.valueOf(flag), message);
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("│=jsonString= : " + jsonString);
		LOG.debug("└──────────────────────────────────┘");
		
		return jsonString;
	}
	
	@RequestMapping(value = "doSelectOne.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String doSelectOne(UserVO inVO) throws SQLException {
		String jsonString = "";
		LOG.debug("┌──────────────────────────────────┐");
		LOG.debug("│=inVO= : " + inVO);
		
		UserVO outVO = userService.doSelectOne(inVO);
		jsonString = new Gson().toJson(outVO);
		
		LOG.debug("│=jsonString= : " + jsonString);
		LOG.debug("└──────────────────────────────────┘");
		
		return jsonString;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String add(UserVO inVO) throws SQLException {
		String jsonString = "";
		LOG.debug("┌──────────────────────────────────┐");
		LOG.debug("│=inVO= : " + inVO);
		int flag = userService.add(inVO);
		
		String message = "";
		if(1 == flag) {
			message = inVO.getuId()+"등록 되었습니다.";
		} else {
			message = inVO.getuId()+"등록 실패.";
		}
		
		MessageVO messageVO = new MessageVO(String.valueOf(flag), message);
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("│=jsonString= : " + jsonString);
		LOG.debug("└──────────────────────────────────┘");
		
		return jsonString;
	}
	
	@RequestMapping(value = "doDelete.do", method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(HttpServletRequest req,UserVO inVO) throws SQLException{
		String jsonString = "";
		
		LOG.debug("┌──────────────────────────────────┐");
		String uId = req.getParameter("uId");
		LOG.debug("│=uId= : " + uId);
		
		//Command객체
		//ajax{uId:'p11_01'}, form(name="uId")
		LOG.debug("│=inVO= : " + inVO);
		UserVO inpuVO = new UserVO();
		inpuVO.setuId(uId);
		
		LOG.debug("│=inpuVO= : " + inpuVO);
		int flag = userService.doDelete(inpuVO);
		
		LOG.debug("│=flag= : " + flag);
		
		String message = "";
		if(1 == flag) {
			message = inpuVO.getuId()+"가 삭제 되었습니다.";
		} else {
			message = inpuVO.getuId()+"가 삭제 안됨.....";
		}
		
		MessageVO messageVO = new MessageVO(String.valueOf(flag),message);
		jsonString = new Gson().toJson(messageVO);
		LOG.debug("jsonString : " + jsonString);
		
		
		LOG.debug("└──────────────────────────────────┘");
		
		return jsonString;
	}
	
}
