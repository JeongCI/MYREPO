package com.pcwk.ehr.hello.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("helloController")
@RequestMapping("hello")
public class HelloController {

	final Logger LOG = LogManager.getLogger(getClass());

	public HelloController() {
	}

	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String view() throws SQLException {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=");
		LOG.debug("└=============================┘");
		return "hello/hello";
	}
}
