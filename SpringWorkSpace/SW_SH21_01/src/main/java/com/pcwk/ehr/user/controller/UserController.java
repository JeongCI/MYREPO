package com.pcwk.ehr.user.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	//화면 파일
	final String VIEW_NAME = "user/user_mng";
	
	  
	public UserController() {}
	
	
	//화면
	@RequestMapping(value="/view.do")
	public String view() {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=                        |");
		LOG.debug("└=============================┘");
		/*
		 * prefix = /WEB-INF/views/
		 *      user/user_mng       ==> /WEB-INF/views/user/user_mng.jsp
		 * suffix = .jsp     
		 */
		return VIEW_NAME;
	}
	
	// http://localhost:8089/ehr/user/upDeleteAll.do?userId=p99_04
	@RequestMapping(value = "/upDeleteAll.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String upDeleteAll(HttpServletRequest req)throws SQLException {
		String jsonString = "";
		
		//p99_04,p99_02,p99_03
		String userIdStr = req.getParameter("userId");
		LOG.debug("┌=============================┐");	
		LOG.debug("|userIdStr="+userIdStr);		
		List<UserVO> list =new ArrayList<UserVO>();
		
		//다건
		if(userIdStr.indexOf(",")!=-1) {
			String[] userArray = userIdStr.split(",");
			for(String uId :userArray) {
				UserVO tmpVO=new UserVO();
				tmpVO.setuId(uId);
				
				list.add(tmpVO);
			}
		//한건	
		}else {
			UserVO tmpVO=new UserVO();
			tmpVO.setuId(userIdStr);
			
			list.add(tmpVO);
		}
		
		int delCnt = this.userService.upDeleteAll(list);
		
		String message = "";
		if(0==delCnt) {
			message = "삭제 실패!";
		}else {
			message = userIdStr+"가 삭제 되었습니다.";
		}
		
		jsonString = new Gson().toJson(new MessageVO(String.valueOf(delCnt), message));
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		
		return jsonString;
	}
	
	
	@RequestMapping(value="/idCheck.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.			
	public String idCheck(UserVO inVO) throws SQLException {
		String jsonString = "";
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		int cnt=userService.idCheck(inVO);
		LOG.debug("|cnt="+cnt);
		
		String message = "";
		if(1==cnt) {
			message = inVO.getuId()+"는 중복되었습니다.";
		}else {
			message = inVO.getuId()+"는 사용 가능합니다.";
		}
		
		jsonString = new Gson().toJson(new MessageVO(String.valueOf(cnt), message));
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");
		
		return jsonString;
	}
	
	
	@RequestMapping(value = "/doRetrive.do",method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.	
	public String doRetrive(SearchVO inVO)throws SQLException{
		String jsonString = "";
		// 페이지 사이즈(default =10)
		if( 0==inVO.getPageSize()) {
			inVO.setPageSize(10);
		}
		
		//페이지 번호(default =1)
		if( 0==inVO.getPageNo()) {
			inVO.setPageNo(1);
		}
		
		//검색구분(default ="")
		if(null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}
		
		// 검색어(default ="")
		if(null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		}
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		
		List<UserVO> list = userService.doRetrive(inVO);
		
		jsonString=new Gson().toJson(list);
		/*
		JSON 값																	
		
		문자열 (string)			{ "site":"cafe" }                                                                                       											
		숫자 (number)				{ "year":2022}                                                                                  											
		객체 (object)				{"UserVO":{"msgId":"1","msgContents":"p99_01수정 되었습니다.","totalCnt":0,"num":0}}                                                                                      											
		배열 (array)					                                                                                        											
		참거짓 (boolean)			{ "member":true }                                                                                       											
		널 (null)					{ "point":null }        											
		*/
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");	
		
		return jsonString;
	}
	
	
	@RequestMapping(value = "/doUpdate.do",method=RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.	
	public String doUpdate(UserVO inVO)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		int flag = userService.doUpdate(inVO);
		
		String message = "";//json으로 전달할 메시지
		if(1==flag) {
			message = inVO.getuId()+"수정 되었습니다.";
		}else {
			message = inVO.getuId()+"수정 실패";
		}
		
		MessageVO messageVO=new MessageVO(String.valueOf(flag), message);
		
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");			
		return 	jsonString;		
	}
	
	@RequestMapping(value = "/doSelectOne.do",method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.	
	public String doSelectOne(UserVO inVO)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);		
		
		UserVO outVO = userService.doSelectOne(inVO);
		
		jsonString = new Gson().toJson(outVO);
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		return jsonString;
	}
	
	
	@RequestMapping(value = "/add.do",method=RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String add(UserVO inVO)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		int flag = userService.add(inVO);
		
		String message = "";//json으로 전달할 메시지
		if(1==flag) {
			message = inVO.getuId()+"등록 되었습니다.";
		}else {
			message = inVO.getuId()+"등록 실패";
		}
		
		MessageVO messageVO=new MessageVO(String.valueOf(flag), message);
		
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");			
		return 	jsonString;
	}
	
	
	//
	@RequestMapping(value = "/doDelete.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doDelete(HttpServletRequest req, UserVO inVO)throws SQLException{
		String jsonString = "";
		
		LOG.debug("┌=============================┐");		
		
		String uId = req.getParameter("uId");
		LOG.debug("|uId="+uId);
		
		//Command객체
		//ajax{uId:'p99_01'},form(name="uId")
		//
		LOG.debug("|inVO="+inVO);
		UserVO inpuVO =new UserVO();
		inpuVO.setuId(uId);
		
		LOG.debug("|inpuVO="+inpuVO);
		
		int flag = userService.doDelete(inpuVO);
		
		LOG.debug("|flag="+flag);
		
		String message = "";
		if(1==flag) {
			message = inpuVO.getuId()+"가 삭제 되었습니다.";
		}else {
			message = inpuVO.getuId()+" 삭제 실패!";
		}
		
		MessageVO  messageVO=new MessageVO(String.valueOf(flag),message);
		
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		return jsonString;
	}
	
	
	
}







