package com.pcwk.ehr.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.user.domain.LevelPieVO;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Controller("userController")
@RequestMapping("user")
public class UserController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	//화면 파일
	final String VIEW_NAME = "user/user_mng";
	
	@Resource(name = "downloadView")
	View download;	
	  
	public UserController() {}
	
	@RequestMapping(value="/doExcelDown.do",method = RequestMethod.POST)
	public ModelAndView doExcelDown(SearchVO inVO,ModelAndView modelAndView) throws SQLException {
		LOG.debug("┌=============================┐");	
		LOG.debug("|SearchVO="+inVO);		
		LOG.debug("└=============================┘");
		
		//1. data조회
		//2. excel 파일생성
		//3. excel 다운로드
		
		//1.
		// 페이지 사이즈(default =10)
		if( 0==inVO.getPageSize()) {
			inVO.setPageSize(10);
		}
		
		//페이지 번호(default =1)
		if( 0==inVO.getPageNo()) {
			inVO.setPageNo(1);
		}
		
		//검색구분(default ="")
		if(null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}
		
		// 검색어(default ="")
		if(null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		}
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		
		List<UserVO> list = userService.doRetrive(inVO);
		for(UserVO vo  :list) {
			LOG.debug("|vo="+vo);
		}
				
		try {
			//Excel파일 생성
			File downloadFile = xlxsWrite("user_mng_"+StringUtil.getCurrentDate(),"c:\\upload",list);    
			
			//download excelfile
			//view지정 : com.pcwk.ehr.file.DownloadView
			modelAndView.setView(download);
			//user_yyyymmdd.xlsx
			String orgFileName = "user_"+StringUtil.getCurrentDate()+"."+"xlsx";
			//원본파일명
			modelAndView.addObject("orgFileNm", orgFileName);
			
			//파일객체
			modelAndView.addObject("downloadFile", downloadFile);			
			
		} catch (IOException | SQLException e) {
			LOG.debug("|IOException="+e.getMessage());
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	/**
	 * 엑셀: 2007이상 버전
	 * 
	 * @param workBook
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws SQLException 
	 */
	private File xlxsWrite(String workBook, String fileName,List<UserVO> list) throws IOException, SQLException {
		//Excel download 일반화
		//1.header 이름 [] 
		//2.header 넓이 []
		//3.data정렬       []
		//4.데이터 출력 순서
		
		int flag = 0;
		// fileName,
		// 2007이상
		Workbook wk = new XSSFWorkbook();

		Sheet sheet01 = wk.createSheet(workBook);
		int rowNo = 0;// row번호
		int cellNo = 0;//cell번호
		
		// header(NO,아이디, 이름, 등급, 이메일, 등록일)
		String header = "NO,아이디,이름,등급,이메일,등록일";
		String[] headerArray = header.split(",");
		
		//header row생성
		
		//header style지정
		CellStyle  headerStyle = wk.createCellStyle();
		
		
		//header line
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		
		//header background
		headerStyle.setFillForegroundColor(IndexedColors.AQUA.index);//배경색
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//채우기
		
		//정렬
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		
		//Font
		Font  headerFont = wk.createFont();
		headerFont.setFontName("나눔고딕");//글씨체
		headerFont.setFontHeight((short)300);//크기
		headerFont.setBold(true);//볼드체
		headerStyle.setFont(headerFont);
		
		Cell cell = null;
		
		Row headerRow = sheet01.createRow(rowNo++);
		sheet01.setColumnWidth(0, 3000);
		sheet01.setColumnWidth(1, 3000);
		sheet01.setColumnWidth(2, 6000);
		sheet01.setColumnWidth(3, 6000);
		sheet01.setColumnWidth(4, 9000);
		sheet01.setColumnWidth(5, 3000);
		
		for(String headerText:headerArray) {
			cell = headerRow.createCell(cellNo++);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(headerText);
			
			//column 넓이 지정
			
			
		}

		// 데이터
		
		CellStyle  dataStyleCenter = wk.createCellStyle();
		dataStyleCenter.setBorderTop(BorderStyle.THIN);
		dataStyleCenter.setBorderBottom(BorderStyle.THIN);
		dataStyleCenter.setBorderLeft(BorderStyle.THIN);
		dataStyleCenter.setBorderRight(BorderStyle.THIN);
		dataStyleCenter.setAlignment(HorizontalAlignment.CENTER);
		
		CellStyle  dataStyleLeft = wk.createCellStyle();
		dataStyleLeft.setBorderTop(BorderStyle.THIN);
		dataStyleLeft.setBorderBottom(BorderStyle.THIN);
		dataStyleLeft.setBorderLeft(BorderStyle.THIN);
		dataStyleLeft.setBorderRight(BorderStyle.THIN);
		dataStyleLeft.setAlignment(HorizontalAlignment.LEFT);
		
		CellStyle  dataStyleRight = wk.createCellStyle();
		dataStyleRight.setBorderTop(BorderStyle.THIN);
		dataStyleRight.setBorderBottom(BorderStyle.THIN);
		dataStyleRight.setBorderLeft(BorderStyle.THIN);
		dataStyleRight.setBorderRight(BorderStyle.THIN);
		dataStyleRight.setAlignment(HorizontalAlignment.RIGHT);
		
		//LOG.debug("list:"+list.size());
		for(int i=0;i<list.size();i++) {
			Row dataRow = sheet01.createRow(rowNo++);
			
			UserVO vo = list.get(i);
			cellNo = 0;
			//NO
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getNum());		
			
			//ID
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getuId());					
			
			//이름
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleLeft);
			cell.setCellValue(vo.getName());
			
			//등급
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getLevel().toString());
			
			//이메일
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleLeft);
			cell.setCellValue(vo.getEmail());
			
			//등록일
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getRegDt());	
			
		}
		
        //파일명: YYYYMMDD+32
		String saveFileName = StringUtil.getPK()+"."+"xlsx";
		File  outFile=new File(fileName, saveFileName);
		
		LOG.debug("|saveFileName="+saveFileName);
		FileOutputStream fos = new FileOutputStream(outFile);
		wk.write(fos);
		fos.close();
		flag = 1;

		return outFile;
	}	
	
	@RequestMapping(value="/drawMemberPieChart.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String drawMemberPieChart() throws SQLException {
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|drawMemberPieChart=");		
		LOG.debug("└=============================┘");
		
		List<LevelPieVO> list =new ArrayList<LevelPieVO>();
		list = this.userService.levelPerMemberCount();		
		//[[],[],[],[],[]]
		JsonArray  jArray=new JsonArray();//1차 배열
		
		for(LevelPieVO vo   :list) {
			JsonArray sArray=new JsonArray();
			sArray.add(vo.getLevelName()); //레벨명
			sArray.add(vo.getLevelCount());//레벨수
		
			jArray.add(sArray);  
		}
		jsonString = jArray.toString();
		LOG.debug("┌=============================┐");	
		LOG.debug("|jsonString="+jsonString);		
		LOG.debug("└=============================┘");		
		
		return jsonString;
	}
	
	@RequestMapping(value="/pieChartView.do")
	public String pieChartView() {
		LOG.debug("┌=============================┐");
		LOG.debug("|pieChartView=                |");
		LOG.debug("└=============================┘");	
		return "user/user_pie";
	}
	
	//화면
	@RequestMapping(value="/view.do")
	public String view() {
		LOG.debug("┌=============================┐");
		LOG.debug("|view=                        |");
		LOG.debug("└=============================┘");
		/*
		 * prefix = /WEB-INF/views/
		 *      user/user_mng       ==> /WEB-INF/views/user/user_mng.jsp
		 * suffix = .jsp     
		 */
		return VIEW_NAME;
	}
	
	// http://localhost:8089/ehr/user/upDeleteAll.do?userId=p99_04
	@RequestMapping(value = "/upDeleteAll.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String upDeleteAll(HttpServletRequest req)throws SQLException {
		String jsonString = "";
		
		//p99_04,p99_02,p99_03
		String userIdStr = req.getParameter("userId");
		LOG.debug("┌=============================┐");	
		LOG.debug("|userIdStr="+userIdStr);		
		List<UserVO> list =new ArrayList<UserVO>();
		
		//다건
		if(userIdStr.indexOf(",")!=-1) {
			String[] userArray = userIdStr.split(",");
			for(String uId :userArray) {
				UserVO tmpVO=new UserVO();
				tmpVO.setuId(uId);
				
				list.add(tmpVO);
			}
		//한건	
		}else {
			UserVO tmpVO=new UserVO();
			tmpVO.setuId(userIdStr);
			
			list.add(tmpVO);
		}
		
		int delCnt = this.userService.upDeleteAll(list);
		
		String message = "";
		if(0==delCnt) {
			message = "삭제 실패!";
		}else {
			message = userIdStr+"가 삭제 되었습니다.";
		}
		
		jsonString = new Gson().toJson(new MessageVO(String.valueOf(delCnt), message));
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		
		return jsonString;
	}
	
	
	@RequestMapping(value="/idCheck.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.			
	public String idCheck(UserVO inVO) throws SQLException {
		String jsonString = "";
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		int cnt=userService.idCheck(inVO);
		LOG.debug("|cnt="+cnt);
		
		String message = "";
		if(1==cnt) {
			message = inVO.getuId()+"는 중복되었습니다.";
		}else {
			message = inVO.getuId()+"는 사용 가능합니다.";
		}
		
		jsonString = new Gson().toJson(new MessageVO(String.valueOf(cnt), message));
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");
		
		return jsonString;
	}
	
	
	@RequestMapping(value = "/doRetrive.do",method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.	
	public String doRetrive(SearchVO inVO)throws SQLException{
		String jsonString = "";
		// 페이지 사이즈(default =10)
		if( 0==inVO.getPageSize()) {
			inVO.setPageSize(10);
		}
		
		//페이지 번호(default =1)
		if( 0==inVO.getPageNo()) {
			inVO.setPageNo(1);
		}
		
		//검색구분(default ="")
		if(null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}
		
		// 검색어(default ="")
		if(null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		}
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		
		List<UserVO> list = userService.doRetrive(inVO);
		
		jsonString=new Gson().toJson(list);
		/*
		JSON 값																	
		
		문자열 (string)			{ "site":"cafe" }                                                                                       											
		숫자 (number)				{ "year":2022}                                                                                  											
		객체 (object)				{"UserVO":{"msgId":"1","msgContents":"p99_01수정 되었습니다.","totalCnt":0,"num":0}}                                                                                      											
		배열 (array)					                                                                                        											
		참거짓 (boolean)			{ "member":true }                                                                                       											
		널 (null)					{ "point":null }        											
		*/
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");	
		
		return jsonString;
	}
	
	
	@RequestMapping(value = "/doUpdate.do",method=RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.	
	public String doUpdate(UserVO inVO)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		int flag = userService.doUpdate(inVO);
		
		String message = "";//json으로 전달할 메시지
		if(1==flag) {
			message = inVO.getuId()+"수정 되었습니다.";
		}else {
			message = inVO.getuId()+"수정 실패";
		}
		
		MessageVO messageVO=new MessageVO(String.valueOf(flag), message);
		
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");			
		return 	jsonString;		
	}
	
	@RequestMapping(value = "/doSelectOne.do",method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.	
	public String doSelectOne(UserVO inVO)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);		
		
		UserVO outVO = userService.doSelectOne(inVO);
		
		jsonString = new Gson().toJson(outVO);
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		return jsonString;
	}
	
	
	@RequestMapping(value = "/add.do",method=RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String add(UserVO inVO)throws SQLException{
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|inVO="+inVO);
		int flag = userService.add(inVO);
		
		String message = "";//json으로 전달할 메시지
		if(1==flag) {
			message = inVO.getuId()+"등록 되었습니다.";
		}else {
			message = inVO.getuId()+"등록 실패";
		}
		
		MessageVO messageVO=new MessageVO(String.valueOf(flag), message);
		
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");			
		return 	jsonString;
	}
	
	
	//
	@RequestMapping(value = "/doDelete.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doDelete(HttpServletRequest req, UserVO inVO)throws SQLException{
		String jsonString = "";
		
		LOG.debug("┌=============================┐");		
		
		String uId = req.getParameter("uId");
		LOG.debug("|uId="+uId);
		
		//Command객체
		//ajax{uId:'p99_01'},form(name="uId")
		//
		LOG.debug("|inVO="+inVO);
		UserVO inpuVO =new UserVO();
		inpuVO.setuId(uId);
		
		LOG.debug("|inpuVO="+inpuVO);
		
		int flag = userService.doDelete(inpuVO);
		
		LOG.debug("|flag="+flag);
		
		String message = "";
		if(1==flag) {
			message = inpuVO.getuId()+"가 삭제 되었습니다.";
		}else {
			message = inpuVO.getuId()+" 삭제 실패!";
		}
		
		MessageVO  messageVO=new MessageVO(String.valueOf(flag),message);
		
		jsonString = new Gson().toJson(messageVO);
		
		LOG.debug("|jsonString="+jsonString);
		LOG.debug("└=============================┘");		
		return jsonString;
	}
	
	
	
}







