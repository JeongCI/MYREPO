package com.pcwk.ehr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello/hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		
		System.out.println("====================");
		System.out.println("=hello()=======");
		System.out.println("====================");
		model.addAttribute("message", "Spring is Good!");
		/*
		 * servlet-context.xml
		 * InternalResourceViewResolver
		 * /WEB-INF/views/+'hello'+.jsp
		 */
		return "hello";
	}
	
}

