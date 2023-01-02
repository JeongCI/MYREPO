package com.pcwk.ehr.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("menuController")
@RequestMapping("menu")
public class MenuController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	public MenuController() {
		
	}
	
	@RequestMapping(value="/tmpMenu.do")
	public String tmpMenuView() {
		String VIEW_NAME="menu/tmpMenu";
		LOG.debug("┌=============================┐");	
		LOG.debug("|tmpMenuView=");			
		LOG.debug("└=============================┘");		
		return VIEW_NAME;
	}
}
