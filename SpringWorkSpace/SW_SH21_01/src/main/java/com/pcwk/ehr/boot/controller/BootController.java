package com.pcwk.ehr.boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("boot")
public class BootController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	
	public BootController() {}
	
	//bootIndex.jsp   
	//bootList.jsp    
	//bootReg.jsp
	@RequestMapping(value = "/bootList.do",method = RequestMethod.GET)
	public String bootList() {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=                        |");
		LOG.debug("└=============================┘");
		/*
		 * prefix = /WEB-INF/views/
		 *      user/user_mng       ==> /WEB-INF/views/user/user_mng.jsp
		 * suffix = .jsp     
		 */		
		return "boot/bootList";
	}
	
	
	@RequestMapping(value = "/bootReg.do",method = RequestMethod.GET)
	public String bootReg() {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=                        |");
		LOG.debug("└=============================┘");
		/*
		 * prefix = /WEB-INF/views/
		 *      user/user_mng       ==> /WEB-INF/views/user/user_mng.jsp
		 * suffix = .jsp     
		 */		
		return "boot/bootReg";
	}
	
	@RequestMapping(value = "/bootIndex.do",method = RequestMethod.GET)
	public String bootIndex() {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=                        |");
		LOG.debug("└=============================┘");
		/*
		 * prefix = /WEB-INF/views/
		 *      user/user_mng       ==> /WEB-INF/views/user/user_mng.jsp
		 * suffix = .jsp     
		 */		
		return "boot/bootIndex";
	}
}
