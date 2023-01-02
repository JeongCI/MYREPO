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
	
	public BootController () {}
	
	//boot.jsp
	//boot_list.jsp
	//boot_reg
	
	@RequestMapping(value = "/bootList.do", method = RequestMethod.GET)
	public String bootList() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                 bootList                  │");
		LOG.debug("└───────────────────────────────────────────┘");		
		
		return "boot/bootList";
	}
	
	@RequestMapping(value = "/bootReg.do", method = RequestMethod.GET)
	public String bootReg() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                 bootReg                   │");
		LOG.debug("└───────────────────────────────────────────┘");		
		
		return "boot/bootReg";
	}

	@RequestMapping(value = "/bootIndex.do", method = RequestMethod.GET)
	public String bootIndex() {
		LOG.debug("┌───────────────────────────────────────────┐");
		LOG.debug("│                bootIndex                  │");
		LOG.debug("└───────────────────────────────────────────┘");		
		
		return "boot/bootIndex";
	}
	
}