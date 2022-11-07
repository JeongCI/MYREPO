package com.pcwk.ehr.board.controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.pcwk.ehr.board.dao.BoardDao;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;

/**
 * Servlet implementation class BoardController
 */
@WebServlet(description = "게시판 컨트롤러", urlPatterns = { "/board/board.do" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final Logger LOG = Logger.getLogger(getClass());
    private BoardDao boardDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
//        LOG.debug("=============================");
//        LOG.debug("=BoardController()=");
//        LOG.debug("=============================");
        boardDao = new BoardDao();
    }

	/**
	 * 최초 1번 수행 이후 수행되지 않음
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
//        LOG.debug("=============================");
//        LOG.debug("=init()=");
//        LOG.debug("=============================");
	}
	
	protected void moveList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==moveList()===");
		LOG.debug("============================");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board.do?work_div=doRetrieve");
		dispatcher.forward(request, response);
	}
	
	protected void moveReg (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==moveReg()===");
		LOG.debug("============================");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board_reg.jsp");
		dispatcher.forward(request, response);
	}
	
	//http://localhost:8089/PC_HTML/board/board.do?work_div=doSave
	protected void doSave (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doSave()===");
		LOG.debug("============================");
		
		BoardVO inVO = new BoardVO();
		String title = StringUtil.nvl(request.getParameter("title"), "");
		String regId = StringUtil.nvl(request.getParameter("reg_id"), "");
		String contents = StringUtil.nvl(request.getParameter("contents"), "");
		
		inVO.setTitle(title);
		inVO.setregId(regId);
		inVO.setModId(regId); //등록자 id와 수정자 id를 동일하게 설정
		inVO.setcontents(contents);
		
		LOG.debug("inVO = "+inVO);
		
		int flag = boardDao.doSave(inVO);
		MessageVO message = new MessageVO();
		String messageContents = "";
		if(1 == flag) {
			messageContents = "등록 되었습니다.";
		} else {
			messageContents = "등록 실패.";
		}
		
		message.setMessageId(String.valueOf(1));
		message.setMsgContents(messageContents);
		
		Gson gson = new Gson();
		String jsonString =  gson.toJson(message);
		
		LOG.debug("============================");         
		LOG.debug("==jsonString()==="+jsonString);
		LOG.debug("============================");
		
		//JSON
		//1 -> 등록 성공
		//-1 -> 등록 실패
		
		//LOG.debug("flag="+flag);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board.do?work_div=doRetrieve");
		//dispatcher.forward(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
	}

	//http://localhost:8089/PC_HTML/board/board.do?work_div=doRetrieve
	protected void doRetrieve (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doRetrieve()===");
		LOG.debug("============================");
		
		SearchVO inVO = new SearchVO();
		//String workDiv = StringUtil.nvl(request.getParameter("work_div"), "");
		String pageNo = StringUtil.nvl(request.getParameter("page_no"), "1");
		String searchDiv = StringUtil.nvl(request.getParameter("search_div"), "");
		String searchWord = StringUtil.nvl(request.getParameter("search_word"), "");
		String pageSize = StringUtil.nvl(request.getParameter("page_size"), "10");
		
		inVO.setPageNo(Integer.parseInt(pageNo));
		inVO.setSearchDiv(searchDiv);
		inVO.setSearchWord(searchWord);
		inVO.setPageSize(Integer.parseInt(pageSize));
		LOG.debug("inVO = "+inVO);    
		
		List<BoardVO> list = boardDao.doRetrieve(inVO);
		
		//list
		for(BoardVO vo : list) {
			LOG.debug(vo);
		}
		
		//view에 데이터 전달
		request.setAttribute("list", list);
		
		int totalCnt = 0;
		//총 글수
		if(null != list && list.size()>0) {
			BoardVO tmpVO = list.get(0);
			totalCnt = tmpVO.getTotalCnt();
		}
		request.setAttribute("totalCnt", totalCnt);
		
		//검색 조건
		request.setAttribute("vo", inVO);
		//데이터 받을 화면 지정
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board_list.jsp");
		//화면으로 전송
		dispatcher.forward(request, response);
		
		//JSON으로 정보 전달
		//Gson gson = new Gson();
		//String jsonString = gson.toJson(inVO);
		//LOG.debug("=============================");
		//LOG.debug("=jsonString="+jsonString);
		//LOG.debug("=============================");
		
		//동일한 화면으로 데이터 전송
		//response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		//out.print(jsonString);
		
		
	}
	
	//http://localhost:8089/PC_HTML/board/board.do?work_div=doUpdate
	protected void doUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doUpdate()===");
		LOG.debug("============================");
		
		BoardVO inVO = new BoardVO();
		String title = StringUtil.nvl(request.getParameter("title"),"");
		String modId = StringUtil.nvl(request.getParameter("mod_id"),"");
		String seq = StringUtil.nvl(request.getParameter("seq"),"-1");
		String contents = StringUtil.nvl(request.getParameter("contents"),"");
		
		inVO.setTitle(title);
		inVO.setModId(modId);
		inVO.setcontents(contents);
		inVO.setSeq(Integer.parseInt(seq));
		
		LOG.debug("inVO" + inVO);
		
		int flag = boardDao.doUpdate(inVO);
		MessageVO message = new MessageVO();
		String messageContents = "";
		if(1 == flag) {
			messageContents = "수정 되었습니다";
		} else {
			messageContents = "수정 실패";
		}
		
		message.setMessageId(String.valueOf(flag));
		message.setMsgContents(messageContents);
		
		jsonSend(response, message);
	}
	
	public void jsonSend(HttpServletResponse response, MessageVO message) throws ServletException, IOException {
		String jsonString = new Gson().toJson(message);
		LOG.debug("============================");         
		LOG.debug("==jsonString==" + jsonString);
		LOG.debug("============================");
		
		//동일한 화면으로 데이터 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
	}
	
	protected void doDeleteAll(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      LOG.debug("============================");
	      LOG.debug("==doDeleteAll()===");
	      LOG.debug("============================");

	      String seqString = StringUtil.nvl(request.getParameter("seq_arr"), "");
	      LOG.debug("seqString: " + seqString);

	      List<BoardVO> seqList = new ArrayList<BoardVO>();

	      if (seqString.indexOf(",") != -1) { // ","가 있으면 다건 처리
	         String[] strArray = seqString.split(",");
	         for (String str : strArray) {
	            BoardVO oneVO = new BoardVO();
	            oneVO.setSeq(Integer.parseInt(str));

	            seqList.add(oneVO);
	         }
	      } else { // 한건
	         BoardVO oneVO = new BoardVO();
	         oneVO.setSeq(Integer.parseInt(seqString));

	         seqList.add(oneVO);
	      }

	      int flag = 0; // 삭제 건수 확인
	      for (BoardVO tmpVO : seqList) {
	         LOG.debug("tmpVO: " + tmpVO);

	         flag += boardDao.doDelete(tmpVO);
	      }

	      LOG.debug("flag: " + flag);
	      
	      MessageVO message = new MessageVO();
	      String msg = "";
	      if(flag>0) {
	         msg = flag+"건 삭제 되었습니다";
	      }else {
	         msg = "삭제 실패!";
	      }
	      
	      message.setMessageId(String.valueOf(flag));
	      message.setMsgContents(msg);
	      
	      String jsonString = new Gson().toJson(message);
	      LOG.debug("============================");
	      LOG.debug("=jsonString()="+jsonString);
	      LOG.debug("============================");
	      
	      //json을 view전송
	      jsonSend(response, message);
	      
	   }
	
	//http://localhost:8089/PC_HTML/board/board.do?work_div=doDelete
	protected void doDelete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doDelete()===");
		LOG.debug("============================");
		
		BoardVO inVO = new BoardVO();
		String seq = StringUtil.nvl(request.getParameter("seq"),"-1");
		inVO.setSeq(Integer.parseInt(seq));
		
		LOG.debug("inVO: "+inVO);
		
		int flag = boardDao.doDelete(inVO);
		MessageVO message = new MessageVO();
		String messageContents = "";
		if(1 == flag) {
			messageContents = "삭제 되었습니다";
		} else {
			messageContents = "삭제 실패";
		}
		
		message.setMessageId(String.valueOf(flag));
		message.setMsgContents(messageContents);
		
		String jsonString = new Gson().toJson(message);
		LOG.debug("============================");         
		LOG.debug("==jsonString()===");
		LOG.debug("============================");
		
		//동일한 화면으로 데이터 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);		
	}
	
	//http://localhost:8089/PC_HTML/board/board.do?work_div=doSelectOne
	protected void doSelectOne (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doSelectOne()===");
		LOG.debug("============================");
		BoardVO inVO = new BoardVO();
		
		//240
		String seq = request.getParameter("seq") == null ? "-1":request.getParameter("seq");
		LOG.debug("=============================");
		LOG.debug("=seq="+seq);
		LOG.debug("=============================");
		inVO.setSeq(Integer.parseInt(seq));
		
		//조회카운트
		boardDao.readCnt(inVO);
		
		// 단건 조회
		BoardVO outVO = boardDao.doSelectOne(inVO);
		LOG.debug("=============================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("=============================");
		
		//화면으로 데이터 전송
		//View에 data 전달
		request.setAttribute("vo", outVO);// 전송 데이터 request set
		//데이터를 받을 화면 지정
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board_mod.jsp");
		//화면으로 전송
		dispatcher.forward(request, response);
		
		//JSON으로 데이터 전송
		Gson gson = new Gson();
		String jsonString = gson.toJson(outVO);
		LOG.debug("=============================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=============================");
		
		//동일한 화면으로 데이터 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        LOG.debug("=============================");
//        LOG.debug("=service()=");
//        LOG.debug("=============================");
        
        //work_div읽어서 분기
        //request encoding을 UTF-8설정
        request.setCharacterEncoding("UTF-8");
        String workDiv = request.getParameter("work_div") == null ? "":request.getParameter("work_div");
        LOG.debug("workDiv = "+workDiv);
        
        switch(workDiv) {
        case "doDeleteAll": //다건 삭제
        	doDeleteAll(request, response);
        	break;
        	
        case "moveList": // 등록화면으로 이동
        	moveList(request,response);
        	break;
        	
        case "moveReg": // 등록화면으로 이동
        	moveReg(request,response);
        	break;
        	
        case "doSave":
        	doSave(request,response);
        	break;
        
        case "doRetrieve":
        	doRetrieve(request,response);
        	break;
        	
        case "doUpdate":
        	doUpdate(request,response);
        	break;
        	
        case "doDelete":
        	doDelete(request,response);
        	break;
        	
        case "doSelectOne":
        	doSelectOne(request,response);
        	break;
        	
        }
        
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("=============================");
        LOG.debug("=doGet()=");
        LOG.debug("=============================");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("=============================");
        LOG.debug("=doPost()=");
        LOG.debug("=============================");
		doGet(request, response);
	}

}
