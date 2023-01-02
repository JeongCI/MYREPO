package com.pcwk.ehr.board.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.board.service.BoardService;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.StringUtil;

@Controller("boardController")
@RequestMapping("board")
public class BoardController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	BoardService  boardService;

	public BoardController() {}
	
	//삭제
	//등록
	//단건조회
	//수정
	//목록조회
	
	/**
	 * 수정
	 * @param inVO
	 * @return JSON(MessageVO)
	 * @throws SQLException
	 */
	@RequestMapping(value="/doUpdate.do",method = RequestMethod.POST
			,produces ="application/json;charset=UTF-8")
	@ResponseBody	
	public String doUpdate(BoardVO inVO) throws SQLException {
		String jsonString = "";
		LOG.debug("┌=============================┐");
		
		MessageVO outMsg=new MessageVO();
		//제목
		if(null != inVO && inVO.getTitle() == null) {
			return StringUtil.validMessageToJson("20","제목을 입력 하세요.");
		}
		
		//내용
		if(null != inVO && inVO.getContents() == null) {
			return StringUtil.validMessageToJson("20","내용을 입력 하세요.");
		}
		
		LOG.debug("|inVO="+inVO);
		LOG.debug("└=============================┘");
		
		int flag = boardService.doUpdate(inVO);
		LOG.debug("┌=============================┐");
		LOG.debug("|flag="+flag);
		
		String message = "";
		if(1==flag) {
			message = inVO.getTitle()+"이 수정 되었습니다.";
		}else {
			message = inVO.getTitle()+" 수정 실패!";
		}		
		
		jsonString = new Gson().toJson(new MessageVO(flag+"", message));
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		return jsonString;
	}
	
	/**
	 * 
	 * @param inVO
	 * @return "board/board_mod"
	 * @throws SQLException
	 */
	@RequestMapping(value="/doSelectOne.do",method = RequestMethod.GET)
	public String doSelectOne(BoardVO inVO, Model model)throws SQLException {
		LOG.debug("┌=============================┐");
		LOG.debug("|inVO:"+inVO);
		LOG.debug("└=============================┘");
		
		
		if(null != inVO && inVO.getSeq() == null) {
			return StringUtil.validMessageToJson("20","순번을 확인 하세요.");
		}
		
		BoardVO outVO = boardService.doSelectOne(inVO);
		LOG.debug("┌=============================┐");
		LOG.debug("|outVO:"+outVO);
		
		model.addAttribute("vo", outVO);		
		LOG.debug("└=============================┘");		
		
		
		return "board/board_mod";
	}
	
	/**
	 * 추가
	 * @param inVO
	 * @return JSON(MessageVO)
	 * @throws SQLException
	 */
	@RequestMapping(value="/doSave.do",method = RequestMethod.POST
			,produces ="application/json;charset=UTF-8")
	@ResponseBody	
	public String doSave(BoardVO inVO) throws SQLException {
		String jsonString = "";
		LOG.debug("┌=============================┐");
		
		MessageVO  outMsg=new MessageVO();
		
		
		//key생성
		if(null != inVO && inVO.getSeq() == null) {
			inVO.setSeq(StringUtil.getPK());
		}
		
		//제목
		if(null != inVO && inVO.getTitle() == null) {
			return StringUtil.validMessageToJson("20","제목을 입력 하세요.");
		}
		
		//내용
		if(null != inVO && inVO.getContents() == null) {
			return StringUtil.validMessageToJson("20","내용을 입력 하세요.");
		}		
		
		LOG.debug("|inVO="+inVO);
		LOG.debug("└=============================┘");	
		int flag = this.boardService.doSave(inVO);
		
		String message = "";
		if(1==flag) {
			message = inVO.getTitle()+"이 등록 되었습니다.";
		}else {
			message = inVO.getTitle()+" 등록 실패!";
		}
		LOG.debug("┌=============================┐");
		LOG.debug("|flag="+flag);
		jsonString = new Gson().toJson(new MessageVO(flag+"", message));
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");	
		return jsonString;
	}
	
	
	/**
	 * 삭제
	 * @param inVO
	 * @return JSON(MessageVO)
	 * @throws SQLException
	 */
	@RequestMapping(value="/doDelete.do",method = RequestMethod.GET
			,produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(BoardVO inVO) throws SQLException {
		String jsonString = "";
		
		LOG.debug("┌=============================┐");
		LOG.debug("|inVO:"+inVO);
		
		int flag = boardService.doDelete(inVO);
			
		LOG.debug("|flag:"+flag);
		
		String message = "";   	
		if(flag ==1) {
			message = "삭제 되었습니다.";
		}else {
			message = "삭제 실패";
		}
		
		jsonString = new Gson().toJson(new MessageVO(String.valueOf(flag), message));
		LOG.debug("|jsonString:"+jsonString);
		LOG.debug("└=============================┘");
		
		return jsonString;
	}
	
	
	
}










