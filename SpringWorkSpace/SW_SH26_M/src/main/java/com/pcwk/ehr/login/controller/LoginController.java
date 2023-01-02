package com.pcwk.ehr.login.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Controller("loginController")
@RequestMapping("login")
public class LoginController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	UserService  userService;
	
	@Autowired
	SessionLocaleResolver localeResolver;
	
	public LoginController() {}
	
	@RequestMapping(value="/doLogin.do",  method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doLogin(@RequestParam(value = "lang", defaultValue = "ko") String lang,
			HttpServletRequest req,Model model)throws SQLException{
		LOG.debug("┌=============================┐");
		LOG.debug("|lang=                        |"+lang);
		LOG.debug("└=============================┘");	
		
		Locale locale = Locale.KOREA;
		String msgContents = "";
		MessageVO  message = new MessageVO();
		if(lang.equals("ko")) {
			locale = Locale.KOREA;
			message.setMsgId("10");
			msgContents = Locale.KOREA+"로 지역이 변경 되었습니다.";
		}else if(lang.equals("en")) {
			locale = Locale.ENGLISH;
			message.setMsgId("20");
			msgContents = "The region has been changed to English";
		}
		model.addAttribute("lang", lang);
		localeResolver.setLocale(req, null, locale);
		
		message.setMsgContents(msgContents);
		
		return new Gson().toJson(message);
	}
	   
	
	//login화면 보여 주기
	@RequestMapping(value="/loginView.do")
	public String loginView() {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=                        |");
		LOG.debug("└=============================┘");
		return "login/login";		
	}
	
	@RequestMapping(value="/doLogout.do")
	public String doLogout(HttpSession session) {
		LOG.debug("┌=============================┐");
		LOG.debug("|doLogout=                    |");
		LOG.debug("└=============================┘");
		
		if(null != session.getAttribute("userInfo") ) {
			session.removeAttribute("userInfo");
			session.invalidate();
			LOG.debug("|session.invalidate()     |");
		}
		return "login/login";		
	}
	
	
	@RequestMapping(value="/doLogin.do",  method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doLogin(UserVO inVO, HttpSession session)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");
		LOG.debug("|param="+inVO);
		
		//10: id가 존재하지 않습니다.
		//20: 비번을 확인 하세요.
		//30: 로그인 되었습니다.
		
		//40: ID 화면입력 체크 
		//50: 비번 화면입력 체크
		MessageVO  outMessage = new MessageVO();
		
		if(null == inVO.getuId()|| "".equals(inVO.getuId())) {
			outMessage.setMsgId("40");
			outMessage.setMsgContents("ID를 입력 하세요.");
			
			return new Gson().toJson(outMessage);
		}
		
		if(null == inVO.getPasswd()|| "".equals(inVO.getPasswd())) {
			outMessage.setMsgId("50");
			outMessage.setMsgContents("비번을 입력 하세요.");
			
			return new Gson().toJson(outMessage);
		}
		
		
		int loginStatus = userService.idPassCheck(inVO);
		
		
		String     message = "";
		if(10 == loginStatus) {
			message = inVO.getuId()+"가 존재하지 않습니다.";
		}else if(20 == loginStatus) {
			message = inVO.getuId()+"의 비번을 확인 하세요.";
		}else if(30 == loginStatus) {
			message = inVO.getuId()+"가 로그인 되었습니다.";
			//------------------------------------------------
			//로그인 정보 조회
			//------------------------------------------------
			UserVO loginInfo = userService.doSelectOne(inVO);
			//접속자 수가 적은 경우(내부사이트)
			if(null !=loginInfo) {
				session.setAttribute("userInfo", loginInfo);
			}
			
			
		}else {
			message = "알수없는 오류!";
		}
		
		outMessage.setMsgId(String.valueOf(loginStatus));
		outMessage.setMsgContents(message);
		
		jsonString = new Gson().toJson(outMessage);
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		return jsonString;
	}
	
	
}
