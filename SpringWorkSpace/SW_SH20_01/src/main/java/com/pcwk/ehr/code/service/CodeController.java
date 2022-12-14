package com.pcwk.ehr.code.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.code.domain.CodeVO;

@Controller("codeController")
@RequestMapping("code")
public class CodeController {
	
	final Logger LOG = LogManager.getFormatterLogger(getClass());
	
	@Autowired
	CodeService codeService;
	
	public CodeController() {}
	
	/**
	 * 코드조회
	 * http://localhost:8089/ehr/code/doRetrive.do?searchWord=PAGE_SIZE,BOARD_SEARCH
	 * @param search
	 * @return JSON(List<CodeVO>)
	 * @throws SQLException
	 */
	@RequestMapping(value="/doRetrive.do",method = RequestMethod.GET
			,produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrive(SearchVO search) throws SQLException {
		String jsonString = "";
		//searchWord = "대분류 코드, 대분류 코드"
		List<String> codeList = new ArrayList<String>();
		String codeStr = search.getSearchWord();
		if(codeStr.indexOf(",")>-1) {
			String[] strArr = codeStr.split(",");
			for(String tmpStr : strArr) {
				codeList.add(tmpStr);
			}
		} else {
			codeList.add(codeStr);
		}
		List<CodeVO> outList = this.codeService.doRetrive(codeList);
		
		jsonString = new Gson().toJson(outList);
		
		LOG.debug("┌=============================┐");
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");	
		
		return jsonString;
	}
	
}
