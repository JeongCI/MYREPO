package com.pcwk.ehr.anno.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ehr.anno.domain.AnnoVO;
import com.pcwk.ehr.anno.service.AnnoService;

@Controller
public class AnnoController {

	@Autowired
	AnnoService annoService;
	
	public AnnoController() {
		
	}
	
	
	@RequestMapping(value="anno/view.do")
	public String annoView() {
		System.out.println("===================================");
		System.out.println("=AnnoController=annoView=");
		System.out.println("===================================");

		//prefix: /WEB-INF/views/
		//        anno/anno   => /WEB-INF/views/anno/anno.jsp
		//suffix: .jsp
		
		
		return "anno/anno";
	}
	
	@RequestMapping(value="anno/doSelectOne.do", method = RequestMethod.POST)
	public String doSelectOne(Model model, HttpServletRequest req) throws SQLException{
		System.out.println("===================================");
		System.out.println("=AnnoController=doSelectOne=");
		System.out.println("===================================");	
		
		String userId = req.getParameter("userId");
		String passwd = req.getParameter("passwd");
		AnnoVO  inVO=new AnnoVO();
		inVO.setUserId(userId);
		inVO.setPasswd(passwd);
		
		System.out.println("===================================");
		System.out.println("=inVO="+inVO);
		System.out.println("===================================");	
		
		AnnoVO outVO = annoService.doSelectOne(inVO);
		model.addAttribute("vo", outVO);
		
		return "anno/anno";
	}
	
	//anno/doSelectOne.do
	
}
